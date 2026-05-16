import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        
        int pos = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if(start > pos) {
                pos = end;
                answer++;
            }
        }
        
        
        return answer;
    }
}