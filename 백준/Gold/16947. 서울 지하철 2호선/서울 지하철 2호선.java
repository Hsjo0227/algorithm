import java.io.*;
import java.util.*;

class Main {
    static int N, start;
    static List<List<Integer>> adj;
    static boolean[] circular, visited;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        visited = new boolean[N+1];
        circular = new boolean[N+1];
        start = -1;
        
        dfs(1, 0);
        
        int[] dist = new int[N+1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N+1];
        
        for(int i = 1; i <= N; i++) {
            if(circular[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }
        
        int depth = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                
                dist[cur] = depth;
                
                for(int next : adj.get(cur)) {
                    
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            depth++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(' ');
        }
        System.out.println(sb);
        
        
    }
    
    public static boolean dfs(int u, int p) {
        
        visited[u] = true;
        
        for(int v : adj.get(u)) {
            if(v == p) continue;
            
            if(!visited[v]) {
                if(dfs(v, u)) {
                    circular[u] = true;
                    if(u == start) {
                        start = -1;
                        return false;
                    }
                    return true;
                    
                }
            } else {
                start = v;
                circular[u] = true;
                return true;
            }
        }
        
        return false;
    }
}