import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<List<int[]>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(start, end)).append('\n');
        }
        System.out.println(sb);
    }
    
    public static int bfs(int start, int end) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
            
        queue.offer(new int[] {start, 0});
        visited[start] = true;
            
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int dist = cur[1];
            
            if(num == end) return dist;
            
            for(int[] arr : adj.get(num)) {
                int next = arr[0];
                int w = arr[1];
                
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] {next, dist + w});
                }
            }
        }
        return 0;
    }
}