import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[N];
        long[] dp = new long[K+1];
        dp[0] = 1;
        
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        for(int coin : coins) {
            for(int i = 0; i <= K - coin; i++) {
                dp[i + coin] += dp[i];
            }
        }
        
        System.out.println(dp[K]);
    }
}