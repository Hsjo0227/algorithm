import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[N][2];
        
        dp[0][0] = 1;
        dp[0][1] = 2;
        
        for(int i = 1; i < N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 9901;
            dp[i][1] = (dp[i-1][1] + 2 * dp[i-1][0] % 9901) % 9901;
        }
        
        System.out.println((dp[N-1][0] + dp[N-1][1]) % 9901);
    }
}