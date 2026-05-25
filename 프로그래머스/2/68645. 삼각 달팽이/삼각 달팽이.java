class Solution {
    private int[] dr = {1, 0, -1};
    private int[] dc = {0, 1, -1};
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        
        int total = n * (n + 1) / 2;
        int r = 0;
        int c = 0;
        int dir = 0;
        
        for(int i = 1; i <= total; i++) {
            arr[r][c] = i;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || nr < nc || arr[nr][nc] != 0) {
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            
            r = nr;
            c = nc;
        }
        
        int[] answer = new int[total];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        
        return answer;
    }
}