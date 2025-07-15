import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[T+1][W+1];
        
        for(int i = 1; i <= T; i++) {
            int input = Integer.parseInt(br.readLine()) - 1;
            
            for(int j = 0; j <= W; j++) {
                dp[i][j] = dp[i-1][j];
                
                if(j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                }
                
                int pos = j % 2;
                if(pos == input) {
                    dp[i][j]++;
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i <= W; i++) {
            answer = Math.max(answer, dp[T][i]);
        }
        
        System.out.println(answer);
    }
}