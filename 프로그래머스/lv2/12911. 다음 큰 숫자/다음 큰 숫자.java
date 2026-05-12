class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = Integer.bitCount(n);
        int next = n + 1;
        while(Integer.bitCount(next) != num) {
            next++;
        }
        
        return next;
    }
}