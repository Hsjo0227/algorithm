import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        int[] torques = new int[4001];
        int[] count = new int[1001];
        
        for(int w : weights) {
            for(int i = 2; i <= 4; i++) {
                answer += torques[i * w];
                torques[i * w]++;
            }
        }
        
        for(int w : weights) {
            answer -= 2 * count[w];
            count[w]++;
        }
        
        return answer;
    }
}