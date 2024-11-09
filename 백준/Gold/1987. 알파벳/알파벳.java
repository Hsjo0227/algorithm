import java.io.*;
import java.util.*;

public class Main {
	static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int answer;
    static int R,C;
    static int[][] board;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new int[R][C];
        
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                int num = str.charAt(j) - 'A';
                board[i][j] = num;
            }
        }
        
        answer = 0;
        dfs(0, 0, (1<<board[0][0]), 1);
        System.out.println(answer);
    }
    
    public static void dfs(int r, int c, int visited, int cnt) {
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            
            if(nr < 0 || nr >= R || nc <0 || nc >=C) continue;
            if(((1<<board[nr][nc]) & visited) ==0) {
            	dfs(nr, nc, visited | (1<<board[nr][nc]), cnt+1);
            }
        }
    }
}
