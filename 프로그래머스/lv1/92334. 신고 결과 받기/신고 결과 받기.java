import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> idMap = new HashMap<>();
        
        int idx = 0;
        for(String str : id_list) {
            map.put(str, new HashSet<>());
            idMap.put(str, idx++);
        }
        
        for(String str : report) {
            StringTokenizer st = new StringTokenizer(str);
            String from = st.nextToken();
            String to = st.nextToken();
            
            map.get(to).add(from);
        }
        
        for(String str : id_list) {
            Set<String> set = map.get(str);
            if(set.size() < k) continue;
            
            for(String from : set) {
                idx = idMap.get(from);
                answer[idx]++;
            }
        }
        
        return answer;
    }
}