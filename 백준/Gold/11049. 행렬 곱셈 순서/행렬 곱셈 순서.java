import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] input = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        
        long[][] dp = new long[N+1][N+1];
        
        for(int L = 2; L <= N; L++) {
            for(int start = 1; start + L - 1 <= N; start++) {
                int end = start + L - 1;
                dp[start][end] = Long.MAX_VALUE;
                for(int mid = start; mid < end; mid++) {
                    long val = dp[start][mid] + dp[mid+1][end]
                        + (long)input[start][0] * input[mid][1] * input[end][1];
                    dp[start][end] = Math.min(dp[start][end], val);
                }
            }
        }
        
        System.out.println(dp[1][N]);
    }
}