import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 두번째 인덱스는 합의 시작 숫자
        int[][] dp = new int[10001][4];
        dp[1] = new int[] {0, 1, 0, 0};
        dp[2] = new int[] {0, 1, 1, 0};
        dp[3] = new int[] {0, 1, 1, 1};
        
        int end = 4; //계산을 시작해야 하는 지점
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            
            for(int i = end; i <= n; i++) {
                dp[i][1] = 1;
                dp[i][2] = dp[i-2][2] + 1; // 1은 dp[i-2][1]과 같음
                dp[i][3] = dp[i-3][3] + dp[i-3][2] + 1;
            }
            end = Math.max(end, n+1);
            int answer = 0;
            for(int i = 1; i <= 3; i++) {
                answer += dp[n][i];
            }
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
        
        
    }
}