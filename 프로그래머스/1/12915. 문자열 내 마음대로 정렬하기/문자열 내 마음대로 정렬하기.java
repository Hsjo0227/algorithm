import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings);
        Arrays.sort(strings, (s1, s2) -> s1.charAt(n) - s2.charAt(n));
        
        return strings;
    }
}