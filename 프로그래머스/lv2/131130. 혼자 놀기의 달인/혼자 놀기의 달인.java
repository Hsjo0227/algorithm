import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int first = 0;
        int second = 0;
        
        int[] counts = new int[cards.length];
        boolean[] visited = new boolean[cards.length];
        
        for(int i = 0; i < cards.length; i++) {
            cards[i]--;
        }
        
        for(int i = 0; i < cards.length; i++) {
            if(visited[i]) continue;
            
            int value = dfs(i, cards, visited);
            
            if(value > first) {
                second = Math.max(second, first);
                first = value;
            } else {
                second = Math.max(second, value);
            }
        }
        
        return first * second;
    }
    
    public int dfs(int num, int[] cards, boolean[] visited) {
        if(visited[num]) return 0;
        visited[num] = true;
        return dfs(cards[num], cards, visited) + 1;
    }
}