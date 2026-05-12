import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String str : participant) {
            Integer num = map.get(str);
            if(num == null) {
                map.put(str, 1);
            } else {
                map.put(str, num+1);
            }
        }
        
        for(String str : completion) {
            Integer num = map.get(str);
            if(num == 1) {
                map.remove(str);
            } else {
                map.put(str, num - 1);
            }
        }
        
        return map.keySet().iterator().next();
    }
}