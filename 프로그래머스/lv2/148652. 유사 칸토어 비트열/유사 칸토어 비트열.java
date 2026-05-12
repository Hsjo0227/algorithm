import java.util.*;

class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i < r; i++) {
            if(!isZero(i)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private boolean isZero(long num) {
        while(num != 0) {
            if(num % 5L == 2L) return true;
            num /= 5L;
        }
        return false;
    }
}