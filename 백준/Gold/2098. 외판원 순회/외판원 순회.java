import java.io.*;
import java.util.*;

class Main {
    static int INF =  1_000_000_000;
    static int N;
    static int[][] adj;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        adj = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxState = 1 << N;
        dp = new int[maxState][N];
        for(int i = 0; i < maxState; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[1][0] = 0;
        
        for(int s = 1; s < maxState; s++) {
            for(int i = 0; i < N; i++) {
                if((s & (1 << i)) == 0) continue;
                int cur = dp[s][i];
                if(cur == INF) continue;
                for(int j = 0; j < N; j++) {
                    if((s & (1 << j)) != 0) continue;
                    if(adj[i][j] == 0) continue;
                    int ns = s | (1 << j);
                    dp[ns][j] = Math.min(dp[ns][j], cur + adj[i][j]);
                }
            }
        }
        
        int answer = INF;
        int full = (1 << N) - 1;
        for(int i = 0; i < N; i++) {
            if(adj[i][0] != 0) {
                answer = Math.min(answer, dp[full][i] + adj[i][0]);
            }
        }
        System.out.println(answer);
    }
   
}