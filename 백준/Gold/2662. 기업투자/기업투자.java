import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N+1][M+1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N+1][M+1];
        int[][] choice = new int[N+1][M+1];
        
        for(int i = 1; i <= M; i++) {
            for(int j = 0; j <= N; j++) {
                dp[j][i] = dp[j][i-1];
                
                for(int k = 1; k <= j; k++) {
                    int num = dp[j-k][i-1] + arr[k][i];
                    if(num > dp[j][i]) {
                        dp[j][i] = num;
                        choice[j][i] = k;
                    }
                }
            }
        }
        
        sb.append(dp[N][M]).append('\n');
        
        int[] invest = new int[M+1];
        
        int money = N;
        for(int i = M; i >= 1; i--) {
            int k = choice[money][i];
            invest[i] = k;
            money -= k;    
        }
        
        for(int i = 1; i <= M; i++) {
            sb.append(invest[i]).append(' ');
        }
        System.out.println(sb);
    }
}