import java.util.*;

class Solution {
    int n;
    boolean[] visited;
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        answer = new String[n+1];
        
        Arrays.sort(tickets, (arr1, arr2) -> {
            if(arr1[0].equals(arr2[0])) {
                return arr1[1].compareTo(arr2[1]);
            } else {
                return arr1[0].compareTo(arr2[0]);
            }
        });
        
        visited = new boolean[n];
        answer[0] = "ICN";
        dfs(tickets, "ICN", 0);
        
        return answer;
    }
    
    private boolean dfs(String[][] tickets, String cur, int cnt) {
        if(cnt == n) {
            return true;
        }
        
        for(int i = 0; i < n; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if(visited[i]) continue;
            if(!from.equals(cur)) continue;
            
            visited[i] = true;
            answer[cnt+1] = to; 
            if(dfs(tickets, to, cnt+1)) return true;
            answer[cnt+1] = null;
            visited[i] = false;
        }
        return false;
    }
}