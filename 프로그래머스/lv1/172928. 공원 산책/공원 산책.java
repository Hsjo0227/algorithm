import java.util.*;

class Solution {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    static int[] position = new int[2];
    static boolean[][] board;
    
    public int[] solution(String[] park, String[] routes) {
        
        board = new boolean[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                char ch = park[i].charAt(j);
                if(ch == 'S') position = new int[] {i, j};
                if(ch != 'X') board[i][j] = true;
            }
        }
        
        for(String route : routes) {
            char dir = route.charAt(0);
            int len = route.charAt(2) - '0';
            
            int idx = -1;
            if(dir == 'N') idx = 0;
            else if(dir == 'S') idx = 1;
            else if(dir == 'W') idx = 2;
            else if(dir == 'E') idx = 3;
            
            if(!check(idx, len)) continue;
            position[0] += len * dr[idx];
            position[1] += len * dc[idx];
        }
        
        
        return position;
    }
    public static boolean check(int idx, int len) {
        
        for(int i = 1; i <= len; i++) {
            int nr = position[0] + (i * dr[idx]);
            int nc = position[1] + (i * dc[idx]);
            
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) return false;
            
            if(board[nr][nc] == false) return false;
        }
        return true;
    }
}