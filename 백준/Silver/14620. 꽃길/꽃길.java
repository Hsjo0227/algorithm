import java.io.*;
import java.util.*;

class Main {
    static int answer, N;
    static int[][] board;
    static boolean[][] visited;
    static int[][] rent;
    static final int[] dr = {-1, 0, 0, 0, 1};
    static final int[] dc = {0, -1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        visited = new boolean[N][N];
        rent = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < N-1; j++) {
                for(int k = 0; k < 5; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    rent[i][j] += board[nr][nc];
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        
        System.out.println(answer);
        
    }
    
    public static void dfs(int idx, int cnt, int money) {
        if(cnt == 3) {
            answer = Math.min(answer, money);
            return;
        }
        if(money > answer) return;
        if(idx > N * N) return;
        
        int r = idx / N;
        int c = idx % N;
        
        boolean flag = true;
        for(int i = 0; i < 5; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                flag = false;
                break;
            }
            if(visited[nr][nc]) {
                flag = false;
                break;
            }
        }
        
        if(flag) {
            for(int i = 0; i < 5; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                visited[nr][nc] = true;
            }
            dfs(idx+1, cnt+1, money+rent[r][c]);
            for(int i = 0; i < 5; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                visited[nr][nc] = false;
            }
        }
        dfs(idx+1, cnt, money);
    }
}