import java.util.*;

class Solution {
    static int INF = Integer.MAX_VALUE / 2;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;   
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] arr :  road) {
            int start = arr[0];
            int end = arr[1];
            int d = arr[2];
            
            adj.get(start).add(new int[]{end, d});
            adj.get(end).add(new int[]{start, d});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        pq.offer(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int no = cur[0];
            int curDist = cur[1];
            
            if (curDist > dist[no]) continue;
            
            for (int[] arr : adj.get(no)) {
                int next = arr[0];
                int nextDist = curDist + arr[1];
                
                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    pq.offer(new int[] {next, nextDist});
                }
            }
            
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}