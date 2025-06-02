import java.io.*;
import java.util.*;

class Main {
    final static int[] dr = {0, -1, 1, 0, 0};
    final static int[] dc = {0, 0, 0, -1, 1};
    
    static int N, answer;
    static int[][] input, board;
    static int[] idxs = new int[3];
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        input = new int[N][N];
        board = new int[N][N];
        visited = new boolean[N][N];
        answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int r = 1; r < N-1; r++) {
            for(int c = 1; c < N-1; c++) {
                int num = 0;
                for(int i = 0; i < 5; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    num += input[nr][nc];
                }
                board[r][c] = num;
            }
        }
        dfs(0, 0);
        
        System.out.println(answer);
    }
    
    public static void dfs(int depth, int cost) {
        if(depth == 3) {
            answer = Math.min(answer, cost);
            return;
        }
        
        
        for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < N-1; j++) {
                if(check(i, j)) continue;
                
                for(int k = 0; k < 5; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    visited[nr][nc] = true;
                }
                
                dfs(depth+1, cost+board[i][j]);
                
                for(int k = 0; k < 5; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    visited[nr][nc] = false;
                }
            }
        }
    }
    public static boolean check(int r, int c) {
        for(int i = 0; i < 5; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(visited[nr][nc]) {
                return true;
            }
        }
        return false;
    }
}