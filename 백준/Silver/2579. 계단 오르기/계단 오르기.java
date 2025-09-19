import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(i > 2) {
                dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3] + arr[i-1]);
            } else {
                int sum = 0;
                for(int j = i; j > 0; j--) {
                    sum += arr[j];
                }
                dp[i] = sum;
            }
        }
        
        System.out.println(dp[N]);
    }
}