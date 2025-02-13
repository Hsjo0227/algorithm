import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int l = score.length;
        int[] answer = new int[l];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < l; i++) {
            pq.offer(score[i]);
            if(pq.size() > k) pq.poll();
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}