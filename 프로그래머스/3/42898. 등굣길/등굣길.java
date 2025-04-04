import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] map = new boolean[m][n];
        
        for(int[] water : puddles) {
            map[water[0]-1][water[1]-1] = true;
        }
        
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            if(map[i][0]) break;
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(map[0][i]) break;
            dp[0][i] = 1;
        }
        
        if(m==1 || n == 1) {
            return (int) dp[m-1][n-1];
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(map[i][j]) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007L;
            }
        }
        
        answer = (int)dp[m-1][n-1];
        
        return answer;
    }
}