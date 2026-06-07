
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long l = 0;
        long r = Long.MAX_VALUE / 2;
        
        while(l < r) {
            long mid = (l + r) / 2;
            long people = 0;
            
            for(int i = 0; i < times.length; i++) {
                people += mid / times[i];
                if(people > n) break;
            }
            
            if(people < n) l = mid + 1;
            else r = mid;
        }
        
        return l;
    }
}