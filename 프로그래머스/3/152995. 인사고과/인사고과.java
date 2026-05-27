import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] arr = scores[0];
        int sum = arr[0] + arr[1];
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });
        
        int max = 0;
        
        for(int[] score : scores) {
            if(score[1] < max) {
                if(score[0] == arr[0] && score[1] == arr[1]) {
                    return -1;
                }
                continue;
            }
            
            max = Math.max(max, score[1]);
            
            if(score[0] + score[1] > sum) {
                answer++;
            }
        }
        
        
        return answer;
    }
}