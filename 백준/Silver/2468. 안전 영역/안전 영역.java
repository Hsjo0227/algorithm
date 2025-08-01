import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int N;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        for(int rain = 0; rain <= 100; rain++) {
            visited = new boolean[N][N];
            int cnt = 0;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && rain < board[i][j]) {
                        bfs(i, j, rain);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        
        System.out.println(answer);
        
    }
    
    public static void bfs(int r, int c, int rain) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            r = cur[0];
            c = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(board[nr][nc] > rain) {
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            
        }
        
    }
}