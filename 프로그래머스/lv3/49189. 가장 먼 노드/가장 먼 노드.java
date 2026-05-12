import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        queue.offer(1);
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            answer = 0;
            while(size-- > 0) {
                answer++;
                int num = queue.poll();
                
                for(int i = 0; i < adj.get(num).size(); i++) {
                    int next = adj.get(num).get(i);
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                
            }
        }
        
        
        return answer;
    }
}