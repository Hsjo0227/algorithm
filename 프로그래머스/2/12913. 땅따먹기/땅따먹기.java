class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int R = land.length;
        int C = 4;
        
        int[][] dp = new int[R+1][4];
        
        for(int i = 1; i <= R; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 0; k < 4; k++) {
                    if(j == k) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = max + land[i-1][j];
            }
        }
        
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[R][i]);
        }
        
        return answer;
    }
}