import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        int end = targets[0][1];
        for(int[] target : targets) {
            if(target[0] < end) continue;
            
            answer++;
            end = target[1];
        }
        
        return answer;
    }
}