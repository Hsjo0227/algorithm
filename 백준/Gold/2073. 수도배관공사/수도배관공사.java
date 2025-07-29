import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[D+1][P+1];
        
        for(int i = 0; i <= P; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            for(int j = 0; j <= D; j++) {
                dp[j][i+1] = Math.max(dp[j][i+1], dp[j][i]);
                
                if(j <= D - L) {
                    int minValue = Math.min(dp[j][i], C);
                    dp[j+L][i+1] = Math.max(dp[j+L][i+1], minValue);
                }
            }
        }
        
        System.out.println(dp[D][P]);
        
    }
}