import java.util.*;

class Solution {
    
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int[][] board;
    static int R, C;
    
    public int solution(String[] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].length();
        board = new int[R][C];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                char ch = maps[i].charAt(j);
                if(ch == 'X') board[i][j] = 1;
                else if(ch == 'S') start = new int[]{i, j};
                else if(ch == 'E') end = new int[]{i, j};
                else if(ch == 'L') lever = new int[]{i, j};
            }
        }
        
        int d = bfs(start , lever);
        answer = d;
        if(d != -1) {
            d = bfs(lever, end);
            if(d != -1) answer += d;
            else answer = -1;
        }
        
        return answer;
    }
    
    public int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                if(r == end[0] && c == end[1]) return depth;
                
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if(board[nr][nc] == 1 || visited[nr][nc]) continue;
                    
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            depth++;
        }
        return -1;
    }
}