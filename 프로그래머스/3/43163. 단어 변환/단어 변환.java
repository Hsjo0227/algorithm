import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String str = queue.poll();
                
                if(str.equals(target)) {
                    return answer;
                }
                
                for(int i = 0; i < words.length; i++) {
                    if(visited[i]) continue;
                    String str2 = words[i];
                    
                    int diff = 0;
                    for(int j = 0; j < str2.length(); j++) {
                        if(str.charAt(j) != str2.charAt(j)) diff++;
                    }
                    
                    if(diff == 1) {
                        
                        queue.offer(str2);
                        visited[i] = true;
                    }
                }
                
            }
            
            
            answer++;
        }
        
        
        return 0;
    }
}