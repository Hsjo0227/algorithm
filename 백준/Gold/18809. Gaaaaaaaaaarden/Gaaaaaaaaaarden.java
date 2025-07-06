import java.io.*;
import java.util.*;

class Main {
    static int N, M, G, R, answer;
    static int[][] board, fertilizer;
    static List<int[]> fertileLand;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        fertilizer = new int[G+R][3];
        
        fertileLand = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    fertileLand.add(new int[] {i, j});
                }
            }
        }
        
        dfs(0, 0, 0);
        
        System.out.println(answer);
        
    }
    
    public static void dfs(int idx, int green, int red) {
        if(green == G && red == R) {
            answer = Math.max(answer, bfs());
            return;
        }
        
        if(idx == fertileLand.size()) {
            return;
        }
        
        if(green < G) {
            int r = fertileLand.get(idx)[0];
            int c = fertileLand.get(idx)[1];
            fertilizer[green+red] = new int[] {r, c, 1};
            dfs(idx+1, green + 1, red);
            fertilizer[green+red] = new int[] {0, 0, 0};
            
        }
        
        if(red < R) {
            int r = fertileLand.get(idx)[0];
            int c = fertileLand.get(idx)[1];
            fertilizer[green+red] = new int[] {r, c, 2};
            dfs(idx+1, green, red + 1);
            fertilizer[green+red] = new int[] {0, 0, 0};
        }
        
        dfs(idx+1, green, red);
    }
    
    public static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        // 도달한 시간도 표시
        int[][][] color = new int[N][M][2];
        for(int i = 0; i < G + R; i++) {
            int r = fertilizer[i][0];
            int c = fertilizer[i][1];
            int status = fertilizer[i][2];
            
            queue.offer(new int[] {r, c, status});
            color[r][c][0] = status;
        }
        
        int count = 0;
        int depth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int status = cur[2];
            
                if(color[r][c][0] == 3) continue;
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(board[nr][nc] == 0) continue;
                    
                    // 다른 배양액 만나면 꽃 추가
                    if((color[nr][nc][0] == 1 && status == 2) ||
                      (color[nr][nc][0] == 2 && status == 1)) {
                        // 같은 시간에 배양액이 도착했을 때만 추가
                        if(color[nr][nc][1] == depth) {
                            color[nr][nc][0] = 3;
                            count++;
                            continue;
                        }
                    }
                    // 이미 방문함
                    if(color[nr][nc][0] != 0) continue;
                    
                    queue.offer(new int[] {nr, nc, status});
                    color[nr][nc][0] = status;
                    color[nr][nc][1] = depth;
                
                }
            }
            
            depth++;
        }
        return count;
    }
}