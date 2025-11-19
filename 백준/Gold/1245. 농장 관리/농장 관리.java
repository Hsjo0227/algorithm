import java.io.*;
import java.util.*;

class Main {
    final static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    final static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        int answer = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] || board[i][j] == 0) continue;
                
                int height = board[i][j];
                boolean flag = true;
                
                queue.clear();
                queue.add(new int[] {i, j});
                visited[i][j] = true;
                
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int r = cur[0];
                    int c = cur[1];
                    
                    for(int k = 0; k < 8; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        
                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        
                        if(board[nr][nc] > height) {
                            flag = false;
                        }
                        if(!visited[nr][nc] && board[nr][nc] == height) {
                            visited[nr][nc] = true;
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                }
                
                if(flag) answer++;
            }
        }
        
        System.out.println(answer);
        
    }
}