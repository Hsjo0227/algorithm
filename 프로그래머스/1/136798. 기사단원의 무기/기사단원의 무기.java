class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int divisor = countDivisor(i);
            if(limit < divisor) answer += power;
            else answer += divisor;
        }
        
        return answer;
    }
    
    public int countDivisor(int num) {
        int count = 0;
        
        for(int i = 1; i * i <= num; i++) {
            if(i * i == num) count++;
            else if(num % i == 0) count += 2;
        }
        
        return count;
    }
}