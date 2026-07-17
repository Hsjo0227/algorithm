import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int m = seller.length;
        int[] answer = new int[n];
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> idxs = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            String child = enroll[i];
            String parent = referral[i];
            
            idxs.put(child, i);
            
            if(parent.equals("-")) continue;
            
            map.put(child, parent);
        }
        
        for(int i = 0; i < m; i++) {
            String sellerName = seller[i];
            int remain = amount[i] * 100;
            
            do {
                int idx = idxs.get(sellerName);
                
                answer[idx] += remain - (remain / 10);
                remain = remain / 10;
                
                sellerName = map.get(sellerName);
                
            } while(sellerName != null && remain != 0);
        }
        
        return answer;
    }
}