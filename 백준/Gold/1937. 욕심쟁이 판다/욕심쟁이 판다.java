import java.io.*;
import java.util.*;

public class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int n;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    static int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];
        
        dp[r][c] = 1;
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if(map[nr][nc] <= map[r][c]) continue;
            
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        
        return dp[r][c];
    }
}