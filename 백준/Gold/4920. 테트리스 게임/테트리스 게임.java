import java.io.*;
import java.util.*;

public class Main {
    static final int[][] dr = {
        {0,0,0,0}, {0,1,2,3},
        {0,0,1,1},
        {0,0,1,1}, {0,1,1,2},
        {0,0,0,1}, {0,1,2,2}, {0,0,0,-1}, {0,-1,-2,-2},
        {0,0,0,1}, {0,1,2,1}, {0,0,0,-1}, {0,-1,-2,-1}
        
    };
    static final int[][] dc = {
        {0,1,2,3}, {0,0,0,0},
        {0,1,1,0},
        {0,1,1,2}, {0,0,-1,-1},
        {0,1,2,2}, {0,0,0,-1}, {0,-1,-2,-2}, {0,0,0,1},
        {0,1,2,1}, {0,0,0,-1}, {0,-1,-2,-1}, {0,0,0,1}
    };
    
    static int N, answer;
    static int[][] board;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine().trim());
        int tc = 1;
        
        while(N != 0){
            
            board = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            answer = Integer.MIN_VALUE;
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    
                    check(r,c);
                    
                }
            }
            
            sb.append(tc++).append(". ").append(answer).append("\n");
            N = Integer.parseInt(br.readLine().trim());
        }
        
        System.out.println(sb);
    }
    
    public static void check(int r, int c) {
        for(int i = 0; i < 13; i++) {
            int sum = 0;
            
            int j = 0;
            for(; j < 4; j++) {
                int nr = r + dr[i][j];
                int nc = c + dc[i][j];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
                
                sum += board[nr][nc];
            }
            
            if(j == 4) {
                answer = Math.max(answer, sum);
            }
        }
    }
}