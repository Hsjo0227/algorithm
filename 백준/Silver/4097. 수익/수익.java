import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        while(N != 0) {
            int answer = Integer.MIN_VALUE;
            int[] dp = new int[N+1];
            for(int i = 1; i <= N; i++) {
                int num = Integer.parseInt(br.readLine());
                dp[i] = Math.max(dp[i-1] + num, num);
                answer = Math.max(answer, dp[i]);
            }
            
            sb.append(answer).append('\n');
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}