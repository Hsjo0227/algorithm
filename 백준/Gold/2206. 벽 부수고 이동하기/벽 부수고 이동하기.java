import java.io.*;
import java.util.*;

public class Main {
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    
    static int N, M;
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
        
        
    }
    
    public static int bfs() {
    	Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        
        queue.offer(new int[] {0, 0, 0});
        visited[0][0][0] = true;
        
        int depth = 1;
        
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            
            while(cnt-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int num = cur[2];
                
                if(r == N-1 && c == M-1){
                    return depth;
                }
                
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(board[nr][nc] == 0) {
                        if(visited[nr][nc][num]) continue;
                        queue.offer(new int[] {nr, nc, num});
                        visited[nr][nc][num] = true;
                    }
                    if(board[nr][nc] == 1) {
                        if(num == 1 || visited[nr][nc][num]) continue;
                        queue.offer(new int[] {nr, nc, num+1});
                        visited[nr][nc][num+1] = true;
                    }
                    
                    
                }
            }
            depth++;
        }
        return -1;
    }
    
}