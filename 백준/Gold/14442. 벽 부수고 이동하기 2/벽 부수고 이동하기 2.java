import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int N, M, K, answer;
    static int[][] board;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        
        answer = -1;
        bfs();
        
        System.out.println(answer);
        
    }
    
    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][M][K+1];
        
        queue.offer(new int[] {0,0,0});
        visited[0][0][0] = true;
        
        int depth = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            // System.out.println("-------------" + depth + "----------------");
            while(size-- > 0) {
                int[] cur = queue.poll();
                int k = cur[2];
                
                if(cur[0] == N-1 && cur[1] == M-1) {
                    answer = depth;
                    return;
                }
                // System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
                for(int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    
                    if(board[nr][nc] == 0 && !visited[nr][nc][k]) {
                        queue.offer(new int[] {nr, nc, k});
                        visited[nr][nc][k] = true;
                    } else if(board[nr][nc] == 1 && k+1 <= K && !visited[nr][nc][k+1]) {
                        queue.offer(new int[] {nr, nc, k+1});
                        visited[nr][nc][k+1] = true;
                    }
                }
                
            }
            depth++;
        }
    }
}