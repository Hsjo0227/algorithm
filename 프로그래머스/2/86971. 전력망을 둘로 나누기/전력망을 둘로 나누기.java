import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();
            
            queue.offer(start);
            visited[start] = true;
            int cnt = 1;
            
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int j = 0; j < adj.get(cur).size(); j++) {
                    int next = adj.get(cur).get(j);
                    
                    if(visited[next]) continue;
                    if(next == end) continue;
                    
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
        }
        
        
        return answer;
    }
}