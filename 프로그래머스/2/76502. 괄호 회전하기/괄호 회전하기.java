import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            if(check(s, i)) answer++;
        }
        
        return answer;
    }
    
    public boolean check(String s, int i) {
        int n = s.length();
        Deque<Character> deque = new ArrayDeque<>();
            
        for(int j = 0; j < n; j++) {
            int idx = (i + j) % n;
            char ch = s.charAt(idx);
            switch(ch) {
                case '[':
                case '(':
                case '{':
                    deque.offerFirst(ch);
                    break;
                case ']':
                    if(deque.isEmpty() || deque.pollFirst() != '[') return false;
                    break;
                case ')':
                    if(deque.isEmpty() || deque.pollFirst() != '(') return false;
                    break;
                case '}':
                    if(deque.isEmpty() || deque.pollFirst() != '{') return false;
                    break;
            }
        }
        if(deque.isEmpty()) return true;
        else return false;
    }
    
}