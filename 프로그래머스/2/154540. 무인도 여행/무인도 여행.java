import java.util.*;

class Solution {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    
    static List<Integer> list;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        n = maps.length;
        m = maps[0].length();
        
        board = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String str = maps[i];
            for(int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if(ch == 'X') continue;
                board[i][j] = ch - '0';
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) continue;
                if(visited[i][j]) continue;
                list.add(bfs(i, j));
            }
        }
        
        Collections.sort(list);
        if(list.isEmpty()) list.add(-1);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int food = 0;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            r = arr[0];
            c = arr[1];
            
            food += board[r][c];
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(board[nr][nc] == 0) continue;
                if(visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        
        return food;
    }
}