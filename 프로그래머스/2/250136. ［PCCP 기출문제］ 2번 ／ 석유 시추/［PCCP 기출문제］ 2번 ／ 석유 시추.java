import java.util.*;

class Solution {
    
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int R, C;
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        R = land.length;
        C = land[0].length;
        
        int[] oil = new int[C];
        visited = new boolean[R][C];
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(land[i][j] == 0 || visited[i][j]) continue;
                
                int[] sol = bfs(land, i, j);
                
                for(int k = 0; k < C; k++) {
                    oil[k] += sol[k];
                }
            }
        }
        
        for(int i = 0; i < C; i++) {
            answer = Math.max(answer, oil[i]);
        }
        
        return answer;
    }
    
    public static int[] bfs(int[][] land, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> save = new ArrayList<>();
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int count = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            r = cur[0];
            c = cur[1];
            
            count++;
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(visited[nr][nc] || land[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
            save.add(cur);
        }
        
        int[] sol = new int[C];
        
        for(int[] cur : save) {
            c = cur[1];
            sol[c] = count;
        }
        
        return sol;
        
    }
}