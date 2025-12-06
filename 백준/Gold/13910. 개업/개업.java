import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[M+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < M; i++) {
            for(int j = i+1; j <= M; j++) {
                int num = arr[i] + arr[j];
                set.add(num);
            }
        }
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        
        for(int i = 1; i <= N; i++) {
            for(int num : set) {
                int prev = i - num;
                if(prev < 0) continue;
                dp[i] = Math.min(dp[i], dp[prev] + 1);
            }
        }
        
        int answer = (dp[N] == Integer.MAX_VALUE/2) ? -1 : dp[N];
        System.out.println(answer);
    }
}