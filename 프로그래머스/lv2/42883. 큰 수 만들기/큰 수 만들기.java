import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();
        
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        
        
        for(int i = 0; i < n; i++) {
            int digit = number.charAt(i) - '0';
            int l = deque.size();
            if(l == 0) {
                deque.offerLast(digit);
                continue;
            }
            
            while(l != 0 && n-i > n-k-l) {
                int num = deque.peekLast();
                if(num < digit) {
                    deque.pollLast();
                    l--;
                } else {
                    break;
                }
            }
            if(l < n-k) {
                deque.offerLast(digit);
            }
        }
        
        for(int num : deque) {
            sb.append(num);
        }
        answer = sb.toString();
        
        return answer;
    }
}