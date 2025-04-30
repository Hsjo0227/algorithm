import java.util.*;

class Solution {
    public static boolean check(int[] diffs, int[] times, long limit, int level) {
        long total = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level){
                total += times[i];
            } else {
                total += (long) (diffs[i]-level) * (times[i]+times[i-1]) + times[i];
            }
            
            if(total > limit) return false;
        }
        return true;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 0;
        for(int num : diffs) {
            right = Math.max(right, num);
        }
        
        answer = right;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}