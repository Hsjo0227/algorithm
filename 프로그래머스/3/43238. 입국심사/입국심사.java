class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long l = 0;
        long r = Long.MAX_VALUE;
        
        while(l < r) {
            long mid = (l+r) / 2;
            long num = 0;
            
            for(int i = 0; i < times.length; i++) {
                num += mid / times[i];
                if(num > n) break;
            }
            
            if(num < n) l = mid+1;
            else r = mid;
        }
        return l;
    }
}