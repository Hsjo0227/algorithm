class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        
        for(; n >= a; ) {
            int num = n / a * b;
            int remain = n % a;
            
            answer += num;
            n = num + remain;
        }
        
        return answer;
    }
}
