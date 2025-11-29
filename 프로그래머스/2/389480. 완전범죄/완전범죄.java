import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        int l = info.length;
        
        int[][] dp = new int[l+1][m];
        for(int i = 0; i <= l; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        dp[0][0] = 0;
        
        for(int i = 0; i < l; i++) {
            int num1 = info[i][0];
            int num2 = info[i][1];
            
            for(int j = 0; j < m; j++) {
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                
                if(dp[i][j] + num1 < n) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + num1);
                }
                
                if(j + num2 < m) {
                    dp[i+1][j+num2] = Math.min(dp[i+1][j+num2], dp[i][j]);
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[l][i]);
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}