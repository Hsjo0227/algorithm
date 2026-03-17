import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        int n = data.length;
        int m = data[0].length;
        
        List<int[]> copy = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int[] arr = Arrays.copyOf(data[i], m);
            copy.add(arr);
        }
        Collections.sort(copy, (arr1, arr2) -> {
            if(arr1[col - 1] != arr2[col - 1]) {
                return Integer.compare(arr1[col - 1], arr2[col - 1]);
            } else {
                return -Integer.compare(arr1[0], arr2[0]);
            }
        });
        
        for(int i = 0; i < n; i++) {
            if(i + 1 < row_begin || i + 1 > row_end) continue;
            int[] arr = copy.get(i);
            int sum = 0;
            
            for(int j = 0; j < m; j++) {
                sum += arr[j] % (i + 1);
            }
            
            answer ^= sum;
        }
        
        
        return answer;
    }
}