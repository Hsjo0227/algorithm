import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new char[12][6];
        
        for(int i = 0; i < 12; i++) {
            String str = br.readLine();
            for(int j = 0; j < 6; j++) {
                char ch = str.charAt(j);
                board[i][j] = ch;
            }
        }
        
        
        boolean poped = false;
        int cnt = 0;

        while(true) {
            if(!pop()) break;
            cnt++;
            fall();
        }

        System.out.println(cnt);
    }

    public static boolean pop() {
        boolean poped = false;
        visited = new boolean[12][6];
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 6; j++) {
                if(board[i][j] == '.') continue;
                Queue<int[]> queue = new ArrayDeque<>();
                List<int[]> list = new ArrayList<>();

                queue.offer(new int[] {i, j});
                visited[i][j] = true;

                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    list.add(cur);

                    for(int dir = 0; dir < 4; dir++) {
                        int nr = cur[0] + dr[dir];
                        int nc = cur[1] + dc[dir];

                        if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
                        if(visited[nr][nc]) continue;
                        if(board[nr][nc] != board[cur[0]][cur[1]]) continue;

                        queue.offer(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }

                if(list.size() < 4) continue;

                poped = true;
                for(int[] pos : list) {
                    board[pos[0]][pos[1]] = '.';
                }
            }
        }
        return poped;
    }

    public static void fall() {
        for(int i = 0; i < 6; i++) {
            int bottom = 11;
            for(int j = 11; j >= 0; j--) {
                if(board[j][i] == '.') continue;
                board[bottom][i] = board[j][i];
                if(bottom != j) board[j][i] = '.';
                bottom--;
            }
        }
    }
}