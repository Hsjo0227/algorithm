import java.util.*;

class Solution {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < lighthouse.length; i++) {
            int start = lighthouse[i][0];
            int end = lighthouse[i][1];
            
            adj[start].add(end);
            adj[end].add(start);
        }
        
        dp = new int[n+1][2];
        dfs(1);
        
        answer = Math.min(dp[1][0], dp[1][1]);
        
        return answer;
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        
        dp[node][0] = 0;
        dp[node][1] = 1;
        
        for(int i = 0; i < adj[node].size(); i++) {
            int child = adj[node].get(i);
            
            if(visited[child]) continue;
            
            dfs(child);
            
            dp[node][0] += dp[child][1];
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            
        }
    }
}