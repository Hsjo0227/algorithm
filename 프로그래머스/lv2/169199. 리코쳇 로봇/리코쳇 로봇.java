import java.util.*;

class Solution {
    final static int[] dr = {-1,1,0,0};
    final static int[] dc = {0,0,-1,1};
    
    static int[][] map;
    static int R, C;
    public int solution(String[] board) {
        int answer = 0;
        R = board.length;
        C = board[0].length();
        
        map = new int[R][C];
        int r = 0;
        int c = 0;
        
        for(int i = 0; i < R; i++) {
            String str = board[i];
            for(int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if(ch == 'D') {
                    map[i][j] = 1;
                } else if(ch == 'G') {
                    map[i][j] = 2;
                } else if(ch == 'R') {
                    r = i;
                    c = j;
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] pos = queue.poll();
                r = pos[0];
                c = pos[1];
                
                if(map[r][c] == 2) return depth;
                
                for(int i = 0; i < 4; i++) {
                    int[] next = move(r, c, i);
                    int nr = next[0];
                    int nc = next[1];
                    
                    if(visited[nr][nc]) continue;
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            depth++;
        }
        
        
        return -1;
    }
    
    private int[] move(int r, int c, int dir) {
        while(true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
                return new int[] {r, c};
            }
            if(map[nr][nc] == 1) {
                return new int[] {r, c};
            }
            r = nr;
            c = nc;
        }
    }
    
}