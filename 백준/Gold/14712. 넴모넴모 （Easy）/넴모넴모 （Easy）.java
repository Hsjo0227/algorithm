import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int cnt;
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new boolean[N][M];
        cnt = 0;
        
        dfs(0);
        
        System.out.println(cnt);
    }
    
    public static void dfs(int idx) {
        if(idx == N * M) {
            if(check()) {
                cnt++;
            }
            return;
        }
        
        int r = idx / M;
        int c = idx % M;
        
        dfs(idx+1);
        if(r > 0 && c > 0 && board[r-1][c-1] && board[r-1][c] && board[r][c-1]) return;
        board[r][c] = true;
        dfs(idx+1);
        board[r][c] = false;
    }
    
    public static boolean check() {
        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < M-1; j++) {
                boolean flag = true;
                for(int a = i; a < i+2; a++) {
                    for(int b = j; b < j+2; b++) {
                        flag &= board[a][b];
                    }
                }
                if(flag) return false;
            }
        }
        return true;
    }
    
}