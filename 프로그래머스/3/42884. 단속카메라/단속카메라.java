import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        int camera = -30001;
        
        Arrays.sort(routes, (arr1, arr2) -> {
            if(arr1[1] == arr2[1]) {
                return Integer.compare(arr1[0], arr2[0]);
            } else {
                return Integer.compare(arr1[1], arr2[1]);
            }
        });
        
        for(int[] arr : routes) {
            int start = arr[0];
            int end = arr[1];
            
            if(start > camera) {
                answer++;
                camera = end;
            }
        }
        
        return answer;
    }
}