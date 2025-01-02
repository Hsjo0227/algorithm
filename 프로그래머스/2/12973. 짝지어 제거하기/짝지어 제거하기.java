import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            int l = list.size();
            
            if(l > 0 && list.get(l-1) == ch) {
                list.remove(l-1);
            } else {
                list.add(ch);
            }
        }
        
        if(list.size() == 0) answer = 1;
        else answer = 0;

        return answer;
    }
}