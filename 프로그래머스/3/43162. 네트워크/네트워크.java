class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int num, int n, int[][] computers) {
        if(visited[num]) return;
        
        visited[num] = true;
        
        for(int i = 0; i < n; i++) {
            if(computers[num][i] == 0) continue;
            if(visited[i]) continue;
            
            dfs(i, n, computers);
        }
    }
}