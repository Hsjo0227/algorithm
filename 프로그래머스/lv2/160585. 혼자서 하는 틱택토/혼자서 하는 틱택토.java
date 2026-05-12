class Solution {
    public int solution(String[] board) {
        int cntO = 0;
        int cntX = 0;
        
        for(String str : board) {
            for(char ch : str.toCharArray()) {
                if(ch == 'O') cntO++;
                else if(ch == 'X') cntX++;
            }
        }
        
        if(!(cntO == cntX || cntO == cntX + 1)) {
            return 0;
        }
        
        boolean oWin = check(board, 'O');
        boolean xWin = check(board, 'X');
        
        if(oWin && xWin) return 0;
        
        if(oWin && (cntO != cntX + 1)) return 0;
        
        if(xWin && (cntO != cntX)) return 0;
        
        return 1;
    }
    
    private boolean check(String[] board, char ch) {
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(0) == ch &&
               board[i].charAt(1) == ch &&
               board[i].charAt(2) == ch) {
                return true;
            }
        }
        
        for(int i = 0; i < 3; i++) {
            if(board[0].charAt(i) == ch &&
               board[1].charAt(i) == ch &&
               board[2].charAt(i) == ch) {
                return true;
            }
        }
        
        if(board[0].charAt(0) == ch &&
           board[1].charAt(1) == ch &&
           board[2].charAt(2) == ch) {
            return true;
        }
        
        if(board[0].charAt(2) == ch &&
           board[1].charAt(1) == ch &&
           board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }
}