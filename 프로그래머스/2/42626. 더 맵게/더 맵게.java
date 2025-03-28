import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int food : scoville) {
            pq.offer(food);
        }
        
        while(pq.peek() < K) {
            if(pq.size() < 2) return -1;
            int first = pq.poll();
            int second = pq.poll();
            int result = first + second*2;
            pq.offer(result);
            answer++;
            
        }
        return answer;
    }
}