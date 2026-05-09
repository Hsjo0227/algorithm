import java.util.*;

class Solution {
    int[] board;
    int answer;
    public int solution(int n) {
        answer = 0;
        board = new int[n];
        Arrays.fill(board, -1);
        
        dfs(n, 0);
        
        return answer;
    }
    
    private void dfs(int n, int idx) {
        if(idx == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(check(n, idx, i)) {
                board[idx] = i;
                dfs(n, idx+1);
                board[idx] = -1;
            }
        }
    }
    
    private boolean check(int n, int idx, int num) {
        for(int i = idx - 1; i >= 0; i--) {
            if(board[i] == num) return false;
        }
        
        for(int i = -n; i <= n; i++) {
            int row = num + i;
            int col = idx + i;
            if(row < 0 || row >= n || col < 0 || col >= n) continue;
            if(board[col] == row) return false;
        }
        
        for(int i = -n; i <= n; i++) {
            int row = num + i;
            int col = idx - i;
            if(row < 0 || row >= n || col < 0 || col >= n) continue;
            if(board[col] == row) return false;
        }
        
        return true;
    }
}