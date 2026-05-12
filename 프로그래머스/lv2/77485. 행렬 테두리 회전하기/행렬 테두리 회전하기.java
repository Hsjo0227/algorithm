import java.util.*;

class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            int[] arr = queries[i];
            int x1 = arr[0] - 1;
            int y1 = arr[1] - 1;
            int x2 = arr[2] - 1;
            int y2 = arr[3] - 1;
            
            int r = x1;
            int c = y1;
            int temp = board[r][c];
            int min = board[r][c];
            int length = 2*(x2 - x1 + 1) + 2*(y2 - y1 + 1) - 4;
            int dir = 0;
            for(int j = 0; j < length - 1; j++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                
                board[r][c] = board[nr][nc];
                min = Math.min(min, board[r][c]);
                
                r = nr;
                c = nc;
                if((r == x1 && c == y1) ||
                   (r == x1 && c == y2) ||
                   (r == x2 && c == y1) ||
                   (r == x2 && c == y2)
                  ) dir++;
            }
            board[r][c] = temp;
            
            answer[i] = min;
        }
        
        
        return answer;
    }
}