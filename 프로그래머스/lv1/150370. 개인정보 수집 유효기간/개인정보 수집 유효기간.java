import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        StringTokenizer st = new StringTokenizer(today, ".");
        
        int currentYear = Integer.parseInt(st.nextToken());
        int currentMonth = Integer.parseInt(st.nextToken());
        int currentDay = Integer.parseInt(st.nextToken());
        
        int[] times = new int[26];
        
        for(String term : terms) {
            st = new StringTokenizer(term);
            int type = st.nextToken().charAt(0) - 'A';
            int time = Integer.parseInt(st.nextToken());
            
            times[type] = time;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i], ". ");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int type = st.nextToken().charAt(0) - 'A';
            
            int dateDiff = (currentYear - year) * 12 * 28 
                            + (currentMonth - month) * 28 
                            + (currentDay - day);
            
            if(dateDiff >= times[type] * 28) {
                list.add(i+1);
            }
            
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}