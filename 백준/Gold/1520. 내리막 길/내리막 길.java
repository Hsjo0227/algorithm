import java.util.*;
import java.io.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int[][] board, dp;
    static int M, N, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        dp = new int[M][N];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int num = dfs(0, 0);
        
        System.out.println(num);
    }
    
    public static int dfs(int r, int c) {
        if(r == M - 1 && c == N - 1) {
            H++;
            return 1;
        }
        int sum = 0;
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
            if(board[r][c] <= board[nr][nc]) continue;
            if(dp[nr][nc] == 0) {
                sum += dfs(nr, nc);
            } else if(dp[nr][nc] != -1){
                sum += dp[nr][nc];
            }
        }
        
        if(sum == 0) {
            dp[r][c] = -1;
        } else {
            dp[r][c] = sum;
        }
        
        return sum;
    }
}