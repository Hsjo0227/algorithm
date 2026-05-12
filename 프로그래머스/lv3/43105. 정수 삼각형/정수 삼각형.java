import java.util.Arrays;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                int value = triangle[i][j];
                if(j <= 0) {
                    dp[i][j] = dp[i - 1][j] + value;
                } else if(j >= i){
                    dp[i][j] = dp[i-1][j-1] + value;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + value;
                }
            }
        }
        
        for(int i = 0; i < height; i++) {
            answer = Math.max(answer, dp[height - 1][i]);
        }
        
        return answer;
    }
}