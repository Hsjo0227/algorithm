import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        
        m = convert(m);
        
        for(String str : musicinfos) {
            StringTokenizer st = new StringTokenizer(str, ",:");
            
            int startHour = Integer.parseInt(st.nextToken());
            int startMinute = Integer.parseInt(st.nextToken());
            int endHour = Integer.parseInt(st.nextToken());
            int endMinute = Integer.parseInt(st.nextToken());
            
            String title = st.nextToken();
            String melody = convert(st.nextToken());
            
            int minute = (endHour - startHour) * 60 + endMinute - startMinute;
            System.out.println(melody);
            
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < minute; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }
            
            melody = sb.toString();
            
            if(melody.contains(m)) {
                if(minute > max) {
                    max = minute;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
    
    private String convert(String m) {
        return m.replace("C#", "1")
            .replace("D#", "2")
            .replace("F#", "3")
            .replace("G#", "4")
            .replace("A#", "5");
    }
}