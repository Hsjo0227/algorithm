import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int[] worksNum = new int[50001];
        
        for(int work : works) {
            worksNum[work]++;
        }
        
        int used = 0;
        int i = 49999;
        for(; i >= 0; i--) {
            if(used + worksNum[i+1] > n) break;
            used += worksNum[i+1];
            worksNum[i] += worksNum[i+1];
            worksNum[i+1] = 0;
        }
        
        if(i == -1) return 0;
        
        worksNum[i+1] -= n - used;
        worksNum[i] += n - used;
        
        for(; i >= 0; i--) {
            long num = worksNum[i+1];
            long stress = (long) (i + 1) * (i + 1) * num;
            answer += stress;
        }
        
        return answer;
    }
}