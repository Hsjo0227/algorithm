import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        List<Integer> numbers = new ArrayList<>();
        int prev = tangerine[0];
        int cnt = 1;
        for(int i = 1; i < tangerine.length; i++) {
            int now = tangerine[i];
            if(now != prev) {
                numbers.add(cnt);
                prev = now;
                cnt = 0;
            }
            cnt++;
        }
        numbers.add(cnt);
        Collections.sort(numbers, Collections.reverseOrder());
        
        int sum = 0;
        for(int num : numbers) {
            if(sum >= k) break;
            sum += num;
            answer++;
        }
        
        return answer;
    }
}