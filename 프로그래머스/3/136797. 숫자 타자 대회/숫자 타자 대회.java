import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = Integer.MAX_VALUE;
        int n = numbers.length();
        
        int[][] pos = {
            {3,1},
            {0,0}, {0,1}, {0,2},
            {1,0}, {1,1}, {1,2},
            {2,0}, {2,1}, {2,2},
        };
        
        int[][] adj = new int[10][10];
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int dx = Math.abs(pos[i][0] - pos[j][0]);
                int dy = Math.abs(pos[i][1] - pos[j][1]);
                int min = Math.min(dx, dy);
                int max = Math.max(dx, dy);
                
                adj[i][j] = min * 3 + (max-min) * 2;
            }
            adj[i][i] = 1;
        }
        
        int[][] dp = new int[10][10];
        for(int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[4][6] = 0;
        
        for(int i = 0; i < n; i++) {
            int num = numbers.charAt(i) - '0';
            int[][] next = new int[10][10];
            
            for(int j = 0; j < 10; j++){
                Arrays.fill(next[j], Integer.MAX_VALUE / 2);
            }
            
            for(int l = 0; l < 10; l++) {
                for(int r = 0; r < 10; r++) {
                    int cur = dp[l][r];
                    if(cur >= Integer.MAX_VALUE / 2) continue;
                    if(num != r) next[num][r] = Math.min(next[num][r], cur + adj[l][num]);
                    if(num != l) next[l][num] = Math.min(next[l][num], cur + adj[r][num]);
                }
            }
            dp = next;
        }
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                answer = Math.min(answer, dp[i][j]);
            }
        }
        
        
        return answer;
    }
}