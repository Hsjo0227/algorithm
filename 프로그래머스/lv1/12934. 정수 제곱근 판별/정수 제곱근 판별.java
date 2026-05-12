class Solution {
    public long solution(long n) {
        long answer = 0;
        double x = Math.sqrt(n);
        if(x%1 == 0.0){
            long i = (long) x+1;
            answer = i*i;
        }
        else {answer = -1;}
        return answer;
    }
}