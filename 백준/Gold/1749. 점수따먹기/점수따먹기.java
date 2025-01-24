import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[][] board = new long[N+1][M+1];
        
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                long num = Long.parseLong(st.nextToken());
                
                board[i][j] = board[i-1][j] + board[i][j-1] - board[i-1][j-1] + num;
            }
        }
        
        long answer = Integer.MIN_VALUE;
        
        for(int r1 = 1; r1 <= N; r1++) {
            for(int c1 = 1; c1 <= M; c1++) {
                for(int r2 = 1; r2 <= r1; r2++) {
                    for(int c2 = 1; c2 <= c1; c2++) {
                        long sum = board[r1][c1] - board[r2-1][c1] - board[r1][c2-1] + board[r2-1][c2-1];
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}