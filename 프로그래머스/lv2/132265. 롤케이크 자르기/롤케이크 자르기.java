import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        int[][] type = new int[2][10001];
        int first = 0;
        int second = 0;
        
        for(int i = 0; i < n; i++) {
            int num = topping[i];
            if(type[1][num] == 0) second++;
            type[1][num]++;
        }
        
        for(int i = 0; i < n; i++) {
            int num = topping[i];
            
            type[1][num]--;
            if(type[1][num] == 0) second--;
            
            if(type[0][num] == 0) first++;
            type[0][num]++;
            
            if(first == second) answer++;
        }
        
        
        return answer;
    }
}