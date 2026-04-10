import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int n, m, answer;
    char[][] board;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        answer = n*m;
        
        board = new char[n+2][m+2];
        System.out.println(board[0][0]);
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                board[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(String request : requests) {
            char ch = request.charAt(0);
            if(request.length() == 1) {
                pullOutExternal(ch);
            } else {
                pullOut(ch);
            }
        }
        
        return answer;
    }
    
    private void pullOutExternal(char ch) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+2][m+2];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            if(board[r][c] == ch) {
                board[r][c] = 0;
                answer--;
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= n+2 || nc < 0 || nc >= m+2) continue;
                if(visited[nr][nc]) continue;
                if(board[nr][nc] != ch && board[nr][nc] != 0) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
    
    private void pullOut(char ch) {
        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= m; c++) {
                if(board[r][c] != ch) continue;
                answer--;
                board[r][c] = 0;
            }
        }
    }
}       