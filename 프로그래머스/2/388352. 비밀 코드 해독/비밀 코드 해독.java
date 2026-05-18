class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        int[] arr = new int[5];
        dfs(1, 0, arr, n, q, ans);
        
        return answer;
    }
    
    private void dfs(int start, int cnt, int[] arr, int n, int[][] q, int[] ans) {
        if(cnt == 5) {
            if(check(arr, q, ans)) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i <= n; i++) {
            arr[cnt] = i;
            dfs(i+1, cnt+1, arr, n, q, ans);
        }
    }
    
    private boolean check(int[] arr, int[][] q, int[] ans) {
        for(int i = 0; i < q.length; i++) {
            int cnt = 0;
            
            for(int num : arr) {
                for(int j = 0; j < q[i].length; j++) {
                    if(num == q[i][j]) {
                        cnt++;
                        break;
                    }
                }
            }
            
            if(cnt != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}