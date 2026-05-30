import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        int time = 0;
        int idx = 0;
        int cnt = 0;
        int total = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                
                time += job[1];
                total += time - job[0];
                cnt++;
            }
        }
        
        answer = total / jobs.length;
        return answer;
    }
}