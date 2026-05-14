import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        
        List<Integer> groups = new ArrayList<>();
        boolean[] used = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(used[i]) continue;
            
            int cnt = 0;
            int num = cards[i] - 1;
            while(!used[num]) {
                used[num] = true;
                cnt++;
                num = cards[num] - 1;
            }
            groups.add(cnt);
        }
        
        if(groups.size() == 1) return 0;
        Collections.sort(groups, Comparator.reverseOrder());
        
        return groups.get(0) * groups.get(1);
    }
}