import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        Arrays.fill(answer, -1);
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]) {
                int idx = deque.pollLast();
                answer[idx] = numbers[i];
            }
            deque.offerLast(i);
        }
        
        return answer;
    }
}