import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int l = players.length;
        
        int[] server = new int[l];
        for(int i = 0; i < l; i++) {
            int need = players[i]/ m;
            if(need > server[i]) {
                int end = Math.min(i + k, l);
                int plus = need - server[i];
                answer += plus;
                
                for(int j = i; j < end; j++) {
                    server[j] += plus;
                }
            }
        }
        
        return answer;
    }
}