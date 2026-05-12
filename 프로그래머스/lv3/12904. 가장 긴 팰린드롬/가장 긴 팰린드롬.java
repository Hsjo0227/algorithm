import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int l = s.length();
        for(int i = 0; i < l; i++) {
            int length = 1;
            for(int j = 1; j < l; j++) {
                if(i+j >= l || i-j < 0) break;
                if(s.charAt(i+j) != s.charAt(i-j)) break;
                length += 2;
            }
            answer = Math.max(length, answer);
        }
        
        for(int i = 0; i < l-1; i++) {
            int length = 0;
            for(int j = 0; j < l; j++) {
                if(i+j+1 >= l || i-j < 0) break;
                if(s.charAt(i+j+1) != s.charAt(i-j)) break;
                length += 2;
            }
            answer = Math.max(length, answer);
        }

        return answer;
    }
}