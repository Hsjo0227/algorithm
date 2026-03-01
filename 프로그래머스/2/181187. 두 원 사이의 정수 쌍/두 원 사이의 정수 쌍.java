import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(long x = 1; x <= r2; x++) {
            long max = (long)Math.sqrt((long)r2 * r2 - x * x);
            
            long min = 0;
            
            if(x < r1) {
                min = (long)Math.ceil(Math.sqrt((long)r1 * r1 - x * x));
            }
            
            answer += (max - min + 1);
            
        }
        return answer * 4;
    }
}