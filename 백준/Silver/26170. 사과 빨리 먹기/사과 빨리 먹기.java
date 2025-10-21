import java.io.*;
import java.util.*;

class Main {
    final static int[] dr = {-1, 1, 0, 0};
    final static int[] dc = {0, 0, -1, 1};
    
    static int[][] board;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        board = new int[5][5];
        visited = new boolean[5][5];
        
        
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        
        visited[sr][sc] = true;
        dfs(sr, sc, 0, 0);
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    
    static void dfs(int r, int c, int cnt, int idx) {
        if(cnt >= 3) {
            answer = Math.min(answer, idx);
            return;
        }
        if(idx >= answer) return;
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
            if(board[nr][nc] == -1) continue;
            if(visited[nr][nc]) continue;
            
            visited[nr][nc] = true;
            int num = board[nr][nc];
            
            if(num == 1) {
                board[nr][nc] = 0;
                dfs(nr, nc, cnt+1, idx+1);
                board[nr][nc] = 1;
            } else {
                dfs(nr, nc, cnt, idx+1);
            }
            
            visited[nr][nc] = false;
        }
    }
}