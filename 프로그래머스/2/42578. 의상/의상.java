import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] arr : clothes) {
            String key = arr[1];
            if(!map.containsKey(key)) map.put(key, 1);
            else map.put(key, map.get(key)+1);
        } 
        
        for(String key : map.keySet()) {
            answer *= map.get(key)+1;
        }
        
        return answer - 1;
    }
}