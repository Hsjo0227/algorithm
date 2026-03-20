import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int m = money.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i = 0; i < m; i++) {
            int coin = money[i];
            for(int j = 1; j <= n; j++) {
                if(j < coin) continue;
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[n];
    }
}