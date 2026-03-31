import java.util.*;

class Solution {
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    
    static int R, C;
    static int[][] map;
    static int[][][] route;
    static boolean[][][] visited;
    static List<Integer> list;
    
    public int[] solution(String[] grid) {
        R = grid.length;
        C = grid[0].length();
        
        list = new ArrayList<>();
        
        map = new int[R][C];
        route = new int[R][C][4];
        visited = new boolean[R][C][4];
        
        for(int i = 0; i < R; i++) {
            String str = grid[i];
            for(int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if(ch == 'L') map[i][j] = -1;
                else if(ch == 'R') map[i][j] = 1;
            }
        }
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                for(int d = 0; d < 4; d++) {
                    if(visited[i][j][d]) continue;
                    dfs(i, j, d);
                }
            }
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private static void dfs(int row, int col, int dir) {
        Deque<int[]> stack = new ArrayDeque<>();
        visited[row][col][dir] = true;
        stack.push(new int[] {row, col, dir, 0});

        while(!stack.isEmpty()) {
            int[] arr = stack.pop();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];
            int l = arr[3];
            
            if(l != 0 && r == row && c == col && d == dir) {
                list.add(l);
                return;
            }
            
            int nr = (r + dr[d] + R) % R;
            int nc = (c + dc[d] + C) % C;
            int nd = (d + map[nr][nc] + 4) % 4;
            
            visited[nr][nc][nd] = true;
            stack.push(new int[] {nr, nc, nd, l+1});
        }
    }
}