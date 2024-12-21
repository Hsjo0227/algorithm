import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0,0,0};
    static int[] dc = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static int M, N, H, cnt;
    static int[][][] box;
    static Queue<int[]> queue;
    static boolean[][][] visited;
    static int goal;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[M][N][H];
        
        queue = new ArrayDeque<>();
        visited = new boolean[M][N][H];
        
        cnt = 0;
        goal = M*N*H;
        
        for(int k = 0; k < H; k++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int i = 0; i < M; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][k] = num;
                    if(num == 1) {
                        queue.offer(new int[] {i, j, k});
                        visited[i][j][k] = true;
                        cnt++;
                    }
                    if(num == -1) goal--;
                }
            }
        }
        
        System.out.println(bfs());
        
    }
    public static int bfs() {
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(cnt == goal) return depth;
            while(size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int h = cur[2];
                
                for(int i = 0; i < 6; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    int nh = h + dh[i];
                    
                    if(nr < 0 || nr >= M || nc < 0 || nc >= N || nh < 0 || nh >= H) continue;
                    if(box[nr][nc][nh] != 0 || visited[nr][nc][nh]) continue;
                    queue.offer(new int[] {nr, nc, nh});
                    visited[nr][nc][nh] = true;
                    cnt++;
                }
            }
            depth++;
        }
        if(cnt == goal) return depth;
        return -1;
    }
}