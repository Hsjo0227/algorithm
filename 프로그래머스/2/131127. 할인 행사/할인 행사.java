import java.util.*;


class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }
        
        if(map.equals(window)) {
            answer++;
        }
        
        for(int i = 10; i < discount.length; i++) {
            String out = discount[i - 10];
            String in = discount[i];
            
            window.put(out, window.get(out) - 1);
            if(window.get(out) == 0) {
                window.remove(out);
            }
            window.put(in, window.getOrDefault(in, 0) + 1);
            
            if(map.equals(window)) {
                answer++;
            }
        }
        
        return answer;
    }
}