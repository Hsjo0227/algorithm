import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static boolean[][] board;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new boolean[N][M];
        int[][] coins = new int[2][2];
        int cnt = 0;
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if(ch == 'o') {
                    coins[cnt++] = new int[] {i, j};
                } else if(ch == '#') {
                    board[i][j] = true;
                }
            }
        }
        
        System.out.println(bfs(coins));
        
        
    }
    
    public static int bfs(int[][] coins) {
        Queue<int[][]> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        queue.offer(coins);
        visited[coins[0][0]][coins[0][1]][coins[1][0]][coins[1][1]] = true;
        
        int depth = 1;
        
        while(!queue.isEmpty()) {
            if(depth > 10) break;
            int size = queue.size();
            while(size-- > 0) {
                int[][] arr = queue.poll();
                
                for(int i = 0; i < 4; i++) {
                    int nr1 = arr[0][0] + dr[i];
                    int nc1 = arr[0][1] + dc[i];
                    int nr2 = arr[1][0] + dr[i];
                    int nc2 = arr[1][1] + dc[i];
                    
                    boolean flag1 = nr1 < 0 || nr1 >= N || nc1 < 0 || nc1 >= M;
                    boolean flag2 = nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= M;
                    
                    if (flag1 ^ flag2) return depth;
                    if (flag1 && flag2) continue;
                    
                    if(board[nr1][nc1]) {
                        nr1 = arr[0][0];
                        nc1 = arr[0][1];
                    }
                    if(board[nr2][nc2]) {
                        nr2 = arr[1][0];
                        nc2 = arr[1][1];
                    }
                    if(visited[nr1][nc1][nr2][nc2]) continue;
                    
                    visited[nr1][nc1][nr2][nc2] = true;
                    int[][] next = new int[][] {{nr1, nc1}, {nr2, nc2}};
                        
                    queue.offer(next);
                }
            }
            depth++;
        }
        return -1;
    }
}