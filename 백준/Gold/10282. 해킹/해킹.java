import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            List<List<int[]>> adj = new ArrayList<>();
            
            for(int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }
            
            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                adj.get(b).add(new int[] {a, s});
            }
            
            int[] dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE/2);
            dist[C] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(arr -> arr[1])
            );
            
            pq.offer(new int[] {C, 0});
            
            while(!pq.isEmpty()) {
                int[] arr = pq.poll();
                int cur = arr[0];
                int d = arr[1];
                
                for(int[] next : adj.get(cur)) {
                    if(dist[cur] + next[1] >= dist[next[0]]) continue;
                    
                    dist[next[0]] = dist[cur] + next[1];
                    pq.offer(new int[] {next[0], dist[next[0]]});
                }
            }
            
            int cnt = 0;
            int time = 0;
            for(int i = 1; i <= N; i++) {
                if(dist[i] == Integer.MAX_VALUE/2) continue;
                cnt++;
                time = Math.max(time, dist[i]);
            }

            sb.append(cnt).append(' ').append(time).append('\n');
        }
        System.out.println(sb);
    }
}