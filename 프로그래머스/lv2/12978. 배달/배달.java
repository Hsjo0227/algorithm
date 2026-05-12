import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : road) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist =  new int[N+1];
        
        queue.offer(1);
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[1] = 0;
        
        while(!queue.isEmpty()) {
            int no = queue.poll();
            
            for(int[] next : adj.get(no)) {
                if(dist[next[0]] > dist[no] + next[1]) {
                    dist[next[0]] = dist[no] + next[1];
                    queue.offer(next[0]);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if(dist[i] == Integer.MAX_VALUE / 2) continue;
            if(dist[i] > K) continue;
            answer++;
        }
        
        return answer;
    }
}