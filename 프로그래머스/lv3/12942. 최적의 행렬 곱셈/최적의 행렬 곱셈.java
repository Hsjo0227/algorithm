import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE/3;
    
    static int[][] matrix;
    static int[][] dp;
    static int N;
    
    public int solution(int[][] matrix_sizes) {
        int answer = INF;
        N = matrix_sizes.length;
        matrix = matrix_sizes;
        
        dp = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
        
        return multiply(0, N - 1);
    }
    
    public static int multiply(int from, int to) {
        if(from == to) return 0;
        
        if(dp[from][to] != INF) {
            return dp[from][to];
        }
        
        for(int mid = from; mid < to; mid++) {
            if(dp[from][mid] == INF) multiply(from, mid);
            if(dp[mid + 1][to] == INF) multiply(mid + 1, to);
            
            int a = matrix[from][0];
            int b = matrix[mid][1];
            int c = matrix[to][1];
            
            int cnt = dp[from][mid] + dp[mid + 1][to] + (a * b * c);
            
            dp[from][to] = Math.min(dp[from][to], cnt);
        }
        
        return dp[from][to];
    }
}