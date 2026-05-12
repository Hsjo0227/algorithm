import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE / 2;
        
        int l = info.length;
        
        int[][] dp = new int[l + 1][m];
        
        for(int i = 0; i <= l; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        
        dp[0][0] = 0;
        
        for(int i = 1; i <= l; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            
            for(int j = 0; j < m; j++) {
                if(dp[i-1][j] + a < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                }
                
                if(j >= b) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - b]);
                }
            }
            
        }
        
        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[l][i]);
        }
        
        answer = (answer == Integer.MAX_VALUE / 2) ? -1 : answer;
        
        return answer;
    }
}