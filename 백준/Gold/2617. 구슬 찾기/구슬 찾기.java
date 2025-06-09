import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] lightAdj = new int[N+1][N+1];
        int[][] heavyAdj = new int[N+1][N+1];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            
            lightAdj[heavy][light] = 1;
            heavyAdj[light][heavy] = 1;
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            
            int lightCount = bfs(lightAdj, i);
            int heavyCount = bfs(heavyAdj, i);
            
            if(lightCount > N/2 || heavyCount > N/2) {
                answer++;
            }
            
        }
        
        System.out.println(answer);
    }
    
    public static int bfs(int[][] adj, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int count = 0;
        
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
                
            for(int i = 1; i <= N; i++) {
                if(adj[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}