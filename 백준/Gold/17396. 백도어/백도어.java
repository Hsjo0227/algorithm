import java.io.*;
import java.util.*;

class Main {
    static int N, M, answer;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if(N == 1) {
            System.out.println(0);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        visited = new boolean[N];
        for(int i = 0; i < N-1; i++) {
            visited[i] = (Integer.parseInt(st.nextToken()) == 1);
        }
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            adj.get(start).add(new int[] {end, cost});
            adj.get(end).add(new int[] {start, cost});
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (long[] arr1, long[] arr2) -> {
                if(arr1[1] == arr2[1]) return Long.compare(arr1[0], arr2[0]);
                else return Long.compare(arr1[1], arr2[1]);
            }
        );
        
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE/2);
        
        
        pq.offer(new long[] {0, 0});
        distance[0] = 0;
        
        while(!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curNum = (int)cur[0];
            long curDistance = cur[1];
            
            if(curNum == N-1) break;
            if(curDistance > distance[curNum]) continue;
            
            visited[curNum] = true;
            for(int[] next : adj.get(curNum)) {
                int nextNum = (int)next[0];
                int nextDistance = next[1];
                
                if(visited[nextNum]) continue;
                
                if(distance[nextNum] > distance[curNum] + nextDistance) {
                    distance[nextNum] = distance[curNum] + nextDistance;
                    pq.offer(new long[] {nextNum, distance[nextNum]});
                }
            }
        }
        
        long answer = -1;
        if(distance[N-1] != Long.MAX_VALUE/2) answer = distance[N-1];
        
        System.out.println(answer);
    }
}