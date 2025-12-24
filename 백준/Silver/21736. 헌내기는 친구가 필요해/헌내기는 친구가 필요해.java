import java.io.*;
import java.util.*;

class Main {
    final static int[] dr = {-1, 1, 0, 0};
    final static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N][M];
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if(ch == 'I') {
                    queue.offer(new int[] {i, j});
                    board[i][j] = 'O';
                } else {
                    board[i][j] = ch;
                }
            }
        }
        
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            
            if(board[r][c] == 'P') cnt++;
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(board[nr][nc] == 'X') continue;
                if(visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        
        System.out.println(cnt == 0 ? "TT" : cnt);
    }
}