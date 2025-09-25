import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            boolean[][] board = new boolean[M][N];
            boolean[][] visited = new boolean[M][N];
            
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                
                board[X][Y] = true;
            }
            
            int cnt = 0;
            
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j] || !board[i][j]) continue;
                    cnt++;
                    
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int a = 0; a < 4; a++) {
                            int nr = cur[0] + dr[a];
                            int nc = cur[1] + dc[a];
                            
                            if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                            if(visited[nr][nc] || !board[nr][nc]) continue;
                            
                            visited[nr][nc] = true;
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                    
                }
            }
            
            sb.append(cnt).append('\n');
        }
        
        System.out.println(sb);
    }
}