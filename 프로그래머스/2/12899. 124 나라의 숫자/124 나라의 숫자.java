class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int r = n % 3;
            n /= 3;

            if (r == 0) {
                answer.append('4');
                n--;
            } else {
                answer.append(r);
            }
        }
        
        return answer.reverse().toString();
    }
}