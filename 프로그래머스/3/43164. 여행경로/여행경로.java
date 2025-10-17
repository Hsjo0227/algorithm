import java.util.*;

class Solution {
    static int l;
    static String[] answer;
    static boolean[] used;
    public String[] solution(String[][] tickets) {
        
        l = tickets.length;
        answer = new String[l+1];
        used = new boolean[l];
        
        Arrays.sort(tickets, (arr1, arr2) -> arr1[1].compareTo(arr2[1]));
        
        answer[0] = "ICN";
        
        dfs(tickets, 1);
        
        return answer;
    }
    
    public boolean dfs(String[][] tickets, int idx) {
        if(idx == l + 1) {
            return true;
        }
        
        for(int i = 0; i < l; i++) {
            if(used[i]) continue;
            String[] arr = tickets[i];
            
            if(!arr[0].equals(answer[idx-1])) continue;
            used[i] = true;
            answer[idx] = arr[1];
            if(dfs(tickets, idx+1)) return true;
            used[i] = false;
            
        }
        return false;
    }
}