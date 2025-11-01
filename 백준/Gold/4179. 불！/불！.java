import java.io.*;
import java.util.*;

class Main {
    final static int[] dr = {-1, 1, 0, 0};
    final static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = new int[2];
        
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'J') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i][j] == 'F') {
                    queue.offer(new int[]{i, j, 1, 0});
                }
            }
        }
        
        queue.offer(new int[]{start[0], start[1], 2, 0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int type = cur[2];
            int time = cur[3];
            
            if(type == 2 && (r == 0 || r == R - 1 || c == 0 || c == C - 1)) {
                System.out.println(time + 1);
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(board[nr][nc] == '#') continue;
                
                if(type == 1) {
                    if(board[nr][nc] == 'F' || board[nr][nc] == '#') continue;
                    board[nr][nc] = 'F';
                    queue.offer(new int[]{nr, nc, 1, time + 1});
                } else{
                    if(board[nr][nc] != '.' || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, 2, time + 1});
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}