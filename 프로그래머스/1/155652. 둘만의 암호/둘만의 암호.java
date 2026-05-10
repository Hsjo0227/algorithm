import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        boolean[] arr = new boolean[26];
        
        for(char ch : skip.toCharArray()) {
            arr[ch - 'a'] = true;
        }
        
        for(char ch : s.toCharArray()) {
            
            for(int i = 0; i < index; i++) {
                ch = (char)(((ch - 'a') + 1) % 26 + 'a');
                while(arr[ch - 'a']) {
                    ch = (char)(((ch - 'a') + 1) % 26 + 'a');
                }
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}