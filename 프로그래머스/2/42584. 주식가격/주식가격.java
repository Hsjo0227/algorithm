import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int price = prices[i];

            while (!deque.isEmpty() && deque.peek()[1] > price) {
                int[] prev = deque.pop();

                int prevIdx = prev[0];

                answer[prevIdx] = i - prevIdx;
            }

            deque.push(new int[] {i, price});
        }

        while (!deque.isEmpty()) {
            int[] prev = deque.pop();

            int prevIdx = prev[0];

            answer[prevIdx] = n - 1 - prevIdx;
        }

        return answer;
    }
}