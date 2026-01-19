import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        board = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                if(ch == '.') continue;
                int num = ch - '0';
                
                fill(i, j, num);
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int num = board[i][j];
                if(num == Integer.MIN_VALUE) {
                    sb.append('*');
                } else if(num >= 10) {
                    sb.append('M');
                } else {
                    sb.append(num);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    
    public static void fill(int r, int c, int num) {
        board[r][c] = Integer.MIN_VALUE;
        for(int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(board[nr][nc] == Integer.MIN_VALUE) continue;
            board[nr][nc] += num;
        }
    }
}