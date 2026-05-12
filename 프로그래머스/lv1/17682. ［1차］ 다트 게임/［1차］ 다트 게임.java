import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Pattern p = Pattern.compile("([0-9])+[S,D,T]([*,#]?)");
        Matcher m = p.matcher(dartResult);
        int[] scores = new int[3];
        
        for(int i=0; i<3; i++) {
            m.find();
            Pattern p2 = Pattern.compile("(\\d+)|([SDT])|([*#])");
            Matcher m2 = p2.matcher(m.group());
            int score=0;
            String bonus=null;
            String option = null;
            
            if(m2.find()) score = Integer.parseInt(m2.group());
            if(m2.find()) bonus = m2.group();
            if(m2.find()) option = m2.group();
            
            if(bonus.equals("D")) {
                score = score * score;
            } else if(bonus.equals("T")) {
                score = score * score * score;
            }
            
            if(option != null) {
                if(option.equals("*")){
                    if(i-1 >= 0) scores[i-1] *= 2;
                    score *= 2;
                } else if(option.equals("#")){
                    score *= -1;
                }
            }
            scores[i] = score;
        }
        for(int i=0; i<3; i++){
            answer = answer + scores[i];
        }
        return answer;
    }
}