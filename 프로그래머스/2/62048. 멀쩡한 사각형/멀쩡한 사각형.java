import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        
        // y = h/w * x
        
        long prev = 0;
        for(long x = 1; x <= w; x++) {
            long y = (long)h * x / w;
            
            if((long)h * x % w == 0) {
                answer -= (y - prev);
            } else {
                answer -= (y - prev + 1);
            }
            
            prev = y;
        }
        
        return answer;
    }
}