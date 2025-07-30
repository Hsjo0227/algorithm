import java.io.*;
import java.util.*;

class Main {
    public static final int[] dr = {-1, 0, 1, 0};
    public static final int[] dc = {0, -1, 0, 1};
    
    public static int N, M, answer, goal;
    public static char[][] board;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int tc = 1;
        while(true) {
            String str = br.readLine();
            if(str == null) break;
            
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(str);
        
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new char[N][M];
            visited = new boolean[N][M];
            
            goal = N * M;
            
            for(int i = 0; i < N; i++) {
                str = br.readLine();
                for(int j = 0; j < M; j++) {
                    board[i][j] = str.charAt(j);
                    if(board[i][j] == '*') goal--;
                }
            }
            
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(board[i][j] != '*') {
                        visited[i][j] = true;
                        dfs(i, j, 1, 0);
                        visited[i][j] = false;
                    }
                }
            }
            if(answer == Integer.MAX_VALUE) answer = -1;
            
            sb.append("Case ")
                .append(tc++)
                .append(": ")
                .append(answer)
                .append('\n');
        }
        System.out.println(sb);
    }
    
    public static void dfs(int r, int c, int l, int depth) {      
        if(l == goal) {
            answer = Math.min(answer, depth);
            return;
        }
        
        
        for(int dir = 0; dir < 4; dir++) {
            
            int opposite = (dir + 2) % 4;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            
            if(board[nr][nc] == '*') continue;
            if(visited[nr][nc]) continue;
            
            int cnt = 0;
            while(true) {
                if(nr < 0 || nr >= N || nc < 0 || nc >= M
                  || board[nr][nc] == '*'
                  || visited[nr][nc]
                  ) {
                    nr = nr + dr[opposite];
                    nc = nc + dc[opposite];
                    break;
                }
                
                visited[nr][nc] = true;
                cnt++;
                
                nr = nr + dr[dir];
                nc = nc + dc[dir];
            }
            
            dfs(nr, nc, l+cnt, depth+1);
            
            while(nr != r || nc != c) {
                visited[nr][nc] = false;
                nr = nr + dr[opposite];
                nc = nc + dc[opposite];
            }
        }
    }
}