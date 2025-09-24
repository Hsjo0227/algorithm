import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<List<int[]>> adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            adj = new ArrayList<>();
            visited = new boolean[N+1];
            
            for(int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }
            
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                
                adj.get(u).add(new int[] {v, w});
                adj.get(v).add(new int[] {u, w});
            }
            
            int answer = dfs(1, 0, 0);
            
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
    
    public static int dfs(int idx, int parent, int c) {
        visited[idx] = true;
        
        int cnt = 0;
        int sum = 0;
        
        for(int[] bridge : adj.get(idx)) {
            int next = bridge[0];
            int cost = bridge[1];
            if(parent == next) continue;
            cnt++;
            if(visited[next]) continue;
            
            sum += dfs(next, idx, cost);
        }
        
        if(parent == 0) {
            return sum;
        }
        
        if(cnt == 0) {
            return c;
        }
        
        return Math.min(sum, c);
    }
}