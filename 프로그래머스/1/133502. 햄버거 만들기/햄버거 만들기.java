import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int num : ingredient) {
            if (deque.size() < 3 || num != 1) {
                deque.offerLast(num);
            } else {
                int num1 = deque.pollLast();
                int num2 = deque.pollLast();
                int num3 = deque.pollLast();
                
                if (num1 == 3 && num2 == 2 && num3 == 1) {
                    answer++;
                } else {
                    deque.offerLast(num3);
                    deque.offerLast(num2);
                    deque.offerLast(num1);
                    deque.offerLast(num);
                }
            }
            
        }
        return answer;
    }
}