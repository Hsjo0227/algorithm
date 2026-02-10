import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<List<Integer>> adj;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        dp = new int[N+1][2];
        visited = new boolean[N+1];
        
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    public static void dfs(int num) {
        visited[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        
        for(int child : adj.get(num)) {
            if(visited[child]) continue;
            dfs(child);
            dp[num][0] += dp[child][1];
            dp[num][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}