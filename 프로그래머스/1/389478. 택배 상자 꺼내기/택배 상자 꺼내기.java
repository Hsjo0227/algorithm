class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 총 몇층?
        int floor = (n + w - 1) / w;
        
        
        for(int i = num; i <= n; ) {
            answer++;
            // 층 수
            int div = (i + w - 1) / w;
            int diff = div * w - i;
            i += diff * 2 + 1;
            
        } 
        
        
        return answer;
    }
}