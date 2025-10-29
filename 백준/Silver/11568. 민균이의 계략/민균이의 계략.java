import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            for(int j = 0; j < N; j++) {
                if(dp[j] < num) continue;
                else {
                    dp[j] = num;
                    break;
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(dp[i] == Integer.MAX_VALUE) break;
            answer++;
        }
        System.out.println(answer);
    }
}