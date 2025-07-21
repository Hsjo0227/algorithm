import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static int N;
    static int[] rate = new int[4];
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 4; i++) {
            rate[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[2*N + 1][2*N + 1]; 
        
        visited[N][N] = true;
        double answer = dfs(N, N, 0);
        
        System.out.println(answer);
    }
    
    public static double dfs(int r, int c, int l) {
        if(l == N) {
            // System.out.println(r +" " + c);
            return 1.0;
        }
        
        double sum = 0;
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            double dirRate = 0.01 * rate[i];
            if(visited[nr][nc]) {
                continue;
            }
            
            visited[nr][nc] = true;
            sum += dirRate * dfs(nr, nc, l+1);
            visited[nr][nc] = false;
        }
        return sum;
    }
}