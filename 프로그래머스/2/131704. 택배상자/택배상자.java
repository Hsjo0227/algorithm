import java.util.*;

class Solution {
    public int solution(int[] order) {
        int box = 1;
        int idx = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();

        while (idx < order.length) {
            while (box <= order[idx]) {
                stack.push(box++);
            }

            if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            } else {
                break;
            }
        }

        return idx;
    }
}