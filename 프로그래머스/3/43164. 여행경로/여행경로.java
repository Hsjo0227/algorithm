import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] used = new boolean[tickets.length];
        
        Arrays.sort(tickets, (arr1, arr2) -> arr1[1].compareTo(arr2[1]));
        
        answer[0] = "ICN";
        dfs(answer, tickets, used, 0);
        
        
        
        return answer;
    }
    
    public boolean dfs(String[] answer, String[][] tickets, boolean[] used, int idx) {
        if(idx == tickets.length) return true;
        
        for(int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            
            if(!ticket[0].equals(answer[idx])) continue;
            if(used[i]) continue;
            
            answer[idx+1] = ticket[1];
            used[i] = true;
            
            if(dfs(answer, tickets, used, idx+1)) return true;
            
            answer[idx+1] = null;
            used[i] = false;
        }
        return false;
        
        
    }
}