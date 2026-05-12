class Solution {
    public int solution(String name) {
        int answer = 0;
        int l = name.length();
        
        for(char ch : name.toCharArray()) {
            answer += Math.min(ch - 'A', 26 - (ch - 'A'));
        }
        
        int move = l - 1;
        for(int i = 0; i < l; i++) {
            int nextIdx = i + 1;
            while(nextIdx < l && name.charAt(nextIdx) == 'A') nextIdx++;
            
            move = Math.min(move, i * 2 + (l - nextIdx));
            
            move = Math.min(move, (l - nextIdx) * 2 + i);
            
        }
        answer += move;
        
        return answer;
    }
}