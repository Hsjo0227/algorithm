class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long K = k;
        long D = d;
        
        answer += d / k + 1;
        
        // y == 0 과 |y| = d인 점을 제외
        for(long x = k; x <= D; x = x + k) {
            long y = (long) Math.sqrt((D * D) - (x * x)) / K;
            answer += y + 1;
            
        }
        
        return answer;
    }
}