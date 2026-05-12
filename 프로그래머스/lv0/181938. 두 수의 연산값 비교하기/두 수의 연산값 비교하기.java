class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String sum = Integer.toString(a) + Integer.toString(b);
        answer = Math.max(Integer.parseInt(sum), 2 * a * b);
        return answer;
    }
}