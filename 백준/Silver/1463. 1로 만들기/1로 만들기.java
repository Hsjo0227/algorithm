import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            int result1 = -1;
            int result2 = -1;
            if(i%3 == 0) result1 = dp[i/3] + 1;
            if(i%2 == 0) result2 = dp[i/2] + 1;
            int result = dp[i-1] + 1;
            if(result1 > 0) result = Math.min(result, result1);
            if(result2 > 0) result = Math.min(result, result2);
            dp[i] = result;
        }
        
        System.out.println(dp[N]);
        
    }
}