import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        
        for(int[] result : results) {
            adj.get(result[1]).add(result[0]);
            adj2.get(result[0]).add(result[1]);
        }
        
        for(int i = 1; i <= n; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            queue.offer(i);
            visited[i] = true;
            int cnt = 1;
            
            while(!queue.isEmpty()) {
                int num = queue.poll();
                
                for(int next : adj.get(num)) {
                    if(!visited[next]) {
                        cnt++;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            queue.offer(i);
            while(!queue.isEmpty()) {
                int num = queue.poll();
                
                for(int next : adj2.get(num)) {
                    if(!visited[next]) {
                        cnt++;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            
            if(cnt == n) answer++;
        }
        
        return answer;
    }
}