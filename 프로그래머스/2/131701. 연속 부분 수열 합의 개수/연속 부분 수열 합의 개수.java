import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        
        Set<Integer> set = new HashSet<>();
        int[][] dp = new int[N][N];
        
        int sum = 0;
        for(int i = 0; i < N; i++) {
            dp[i][i] = elements[i];
            set.add(elements[i]);
            sum += elements[i];
        }
        set.add(sum);
        
        for(int l = 0; l < N - 2; l++) {
            for(int start = 0; start < N; start++) {
                int end = (start + l) % N;
                int next = (end + 1) % N;
                
                sum = dp[start][end] + elements[next];
                set.add(sum);
                dp[start][next] = sum;
            }
        }
        
        answer = set.size();
        return answer;
    }
}