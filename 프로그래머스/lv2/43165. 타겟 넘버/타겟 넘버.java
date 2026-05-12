import java.util.*;

class Solution {
    static int[] arr;
    static int answer, t;
    public int solution(int[] numbers, int target) {
        answer = 0;
        arr = numbers;
        t = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int idx, int num) {
        if(idx == arr.length) {
            if(num == t) answer++;
            return;
        }
        
        dfs(idx+1, num+arr[idx]);
        dfs(idx+1, num-arr[idx]);
    }
}