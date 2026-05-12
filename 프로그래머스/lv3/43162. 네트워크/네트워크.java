import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            bfs(n, computers, i);
            answer++;
        }
        
        
        return answer;
    }
    
    public void bfs(int n, int[][] adj, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int i = 0; i < n; i++) {
                if(i == num) continue;
                if(adj[num][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                } 
            }
            
        }
    }
    
}