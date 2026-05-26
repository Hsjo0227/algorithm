import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        
        int r = 0;
        int c = 0;
        
        for(char ch : dirs.toCharArray()) {
            int nr = r;
            int nc = c;
            switch(ch) {
                case 'U':
                    nc = Math.min(5, nc + 1);
                    break;
                case 'D':
                    nc = Math.max(-5, nc - 1);
                    break;
                case 'L':
                    nr = Math.max(-5, nr - 1);
                    break;
                case 'R':
                    nr = Math.min(5, nr + 1);
                    break;
            }
            if(nr == r && nc == c) continue;
            set.add(r + "," + c + "-" + nr + "," + nc);
            set.add(nr + "," + nc + "-" + r + "," + c);
            r = nr;
            c = nc;
        }
        
        answer = set.size() / 2;
        return answer;
    }
}