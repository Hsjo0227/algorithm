import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int key = -30001;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
            
        });
        int count = 0;
        for (int i = 0; i < routes.length; i++) {
            if(routes[i][0] > key) {
                count++;
                key = routes[i][1];
            }
        }
        
        
        return count;
    }
}