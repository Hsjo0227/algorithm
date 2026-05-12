class Solution {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if(board[h][w].equals(board[nr][nc])) answer++;
        }
        
        return answer;
    }
}