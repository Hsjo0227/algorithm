class Solution {
    public String solution(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(' ');
                count = 0;
                continue;
            }
            if(count%2==0) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
            count++;
        }
        
        
        String answer = sb.toString();
        return answer;
    }
}