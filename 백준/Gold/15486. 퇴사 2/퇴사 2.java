import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+2];
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            
            if(i + T <= N+1) {
                dp[i + T] = Math.max(dp[i + T], dp[i] + P);
            }
        }
        
        dp[N+1] = Math.max(dp[N], dp[N+1]);
        
        System.out.println(dp[N+1]);
    }
}