import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][N];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            
            for(int r = X; r <= X+L-1; r++) {
                for(int c = Y; c <= Y+L-1; c++) {
                    board[r][c] = F;
                }
            }
        }
        
        int answer = 0;
        int[][] dp = new int[N][N];
        
        for(int a = 1; a <= 7; a++) {
            for(int b = a; b <= 7; b++) {
                int max = 0;
                
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        int f = board[i][j];
                        if(f == a || f == b) {
                            if(i == 0 || j == 0) {
                                dp[i][j] = 1;
                            } else {
                                dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                            }
                            max = Math.max(max, dp[i][j]);
                        } else {
                            dp[i][j] = 0;
                        }
                    }
                }
                answer = Math.max(answer, max);
            }
        }
        
        System.out.println(answer * answer);
        
    }
}