class Solution {
    public int solution(String s) {
        int answer = 1;
        
        char ch = s.charAt(0);
        
        int equal = 1;
        int diff = 0;
        
        for(int i = 1; i < s.length(); i++) {
            char ch2 = s.charAt(i);
            
            if(ch == ch2) equal++;
            else diff++;
            
            if(equal == diff) {
                if(i+1 >= s.length()) break;
                ch = s.charAt(i+1);
                answer++;
                equal = 1;
                diff = 0;
                i++;
            } 
        }
        
        return answer;
    }
}