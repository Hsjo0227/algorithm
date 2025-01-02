import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zeros = 0;
        
        while(!s.equals("1")) {
            int prev = s.length();
            
            s = s.replace("0", "");
            int next = s.length();
            zeros += prev - next;
            
            s = Integer.toBinaryString(next);
            cnt++;
        }
        
        
        answer = new int[] {cnt, zeros};
        return answer;
    }
}