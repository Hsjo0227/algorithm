class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
        int l = 1;
        int r = 1;
        int sum  = 0;
        
        while(r <= n) {
            sum += r;
            while(l < r && sum > n) {
                sum -= l;
                l++;
            }
            if(sum == n) answer++;
            r++;
        }
        
        return answer;
    }
}