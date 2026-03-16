class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        
        for(int i = 0; i < 24; i++) {
            int player = players[i];
            if(server[i] * m >= player) continue;
            
            int need = player / m;
            int add = need - server[i];
            
            answer += add;
            for(int j = 0; j < k; j++) {
                if(i + j >= 24) break;
                server[i + j] += add;
            }
        }
        return answer;
    }
}