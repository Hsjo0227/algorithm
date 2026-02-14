import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int N, M, wolf, sheep;
    static char[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                if(board[i][j] == '#') continue;
                bfs(i, j);
            }
        }
        
        System.out.println(sheep + " " + wolf);
    }
    
    public static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int v = 0;
        int k = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            r = cur[0];
            c = cur[1];
            
            if(board[r][c] == 'v') v++;
            if(board[r][c] == 'k') k++;
            
            for(int i= 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(board[nr][nc] == '#') continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        if(v < k) sheep += k;
        else wolf += v;
    }
}