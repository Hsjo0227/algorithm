import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0;
        long right = Long.MAX_VALUE / 2;
        
        while(left < right) {
            long mid = (left + right) / 2;
            long people = 0;
            
            for(int i = 0; i < times.length; i++) {
                people += mid / times[i];
                if(people > n) break;
            }
            
            if(people < n) left = mid+1;
            else right = mid;
        }
        
        return left;
    }
}