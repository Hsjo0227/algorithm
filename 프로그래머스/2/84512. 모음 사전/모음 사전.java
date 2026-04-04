import java.util.*;

class Solution {
    static final char[] chs = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list;
    static StringBuilder sb;
    
    public int solution(String word) {
        int answer = 0;
        sb = new StringBuilder();
        list = new ArrayList<>();
        
        make(sb);
        answer = list.indexOf(word);
        
        return answer;
    }
    
    public static void make(StringBuilder sb) {
        if(sb.length() >= 6) return;
        list.add(sb.toString());
        for(int i = 0; i < 5; i++) {
            sb.append(chs[i]);
            make(sb);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}