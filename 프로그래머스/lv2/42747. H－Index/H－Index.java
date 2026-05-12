import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        int i = 0;
        for(; i < n; i++) {
            if(citations[n-1-i] < i+1) break;
        }
        answer = i;
        return answer;
    }
}