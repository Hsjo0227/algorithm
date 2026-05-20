import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = k;
        
        Arrays.sort(tangerine);
        
        List<Integer> list = new ArrayList<>();
        
        int prev = tangerine[0];
        int cnt = 1;
        for(int i = 1; i < tangerine.length; i++) {
            int num = tangerine[i];
            if(tangerine[i] == prev) {
                cnt++;
                continue;
            } else {
                list.add(cnt);
                prev = tangerine[i];
                cnt = 1;
            }
        }
        list.add(cnt);
        list.sort(Comparator.reverseOrder());
        
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if(sum >= k) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}