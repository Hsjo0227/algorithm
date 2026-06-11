import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        int max = -Integer.MAX_VALUE;
        Arrays.sort(routes, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        
        for(int[] route : routes) {
            if(route[0] > max) {
                max = route[1];
                answer++;
            }
        }
        
        
        return answer;
    }
}