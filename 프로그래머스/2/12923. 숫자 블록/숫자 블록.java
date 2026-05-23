import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int n = (int)(end - begin + 1);
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            long num = i + begin;
            answer[i] = getBlock(num);
        }
        
        return answer;
    }
    
    private int getBlock(long num) {
        if(num == 1) return 0;
        
        int result = 1;
        
        for(long div = 2; div * div <= num; div++) {
            if(num % div == 0) {
                long div2 = num/div;
                
                if(div2 <= 10_000_000) {
                    return (int) div2;
                }
                
                if(div <= 10_000_000) {
                    result = (int) div;
                }
            }
        }
        
        return result;
    }
}


