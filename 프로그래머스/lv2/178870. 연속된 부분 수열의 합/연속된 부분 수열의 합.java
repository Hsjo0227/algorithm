class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = new int[] {0, n};
        
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r < n) {
            sum += sequence[r++];
            
            while(l < r && sum > k) {
                sum -= sequence[l++];
            }
            if(sum == k) {
                if(r - l - 1 >= answer[1] - answer[0]) continue;
                answer[0] = l;
                answer[1] = r-1;
            } 
        }
        
        return answer;
    }
}