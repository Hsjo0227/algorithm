import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                int num = str.charAt(j) - '0';
                
                if(num <= 1) {
                    board[i][j] = num;
                } else if(num == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    continue;
                } else if(num >= 3) {
                    board[i][j] = 3;
                }
            }
        }
        
        int depth = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();            
            while(size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                
                if(board[r][c] == 3) {
                    System.out.println("TAK");
                    System.out.println(depth);
                    return;
                }
                
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(board[nr][nc] == 1) continue;
                    if(visited[nr][nc]) continue;
                    
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
            depth++;
        }
        
        System.out.println("NIE");
    }
}