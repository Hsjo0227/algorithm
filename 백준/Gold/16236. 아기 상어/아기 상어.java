import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};
    
    static int N, answer, exp;
    static int[] shark;
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        shark = new int[3];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    shark[2] = 2;
                } else {
                    board[i][j] = num;
                }
            }
        }
        
        int dist = move(shark[0], shark[1]);
        while(dist != 0) {
            answer += dist;
            dist = move(shark[0], shark[1]);
        }
        
        System.out.println(answer);
        
        
    }
    
    public static int move(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int depth = 0;
        List<int[]> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] pos = queue.poll();
                r = pos[0];
                c = pos[1];
                
                if(board[r][c] > 0 && board[r][c] < shark[2]) {
                    list.add(new int[] {r, c});
                }
                
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(visited[nr][nc]) continue;
                    if(board[nr][nc] > shark[2]) continue;
                    
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
                
            }
            if(list.size() > 0) break;
            depth++;
        }
        
        if(list.size() == 0) return 0;
        
        list.sort((a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        int[] pos = list.get(0);
        
        shark[0] = pos[0];
        shark[1] = pos[1];
        exp++;
        
        if(exp == shark[2]) {
            exp = 0;
            shark[2]++;
        }
        
        board[pos[0]][pos[1]] = 0;
        
        
        return depth;
    }
}