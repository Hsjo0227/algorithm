import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            int time = schedules[i] + 10;
            if(time % 100 >= 60) time += 40;
            
            schedules[i] = time;
        }
        
        startday--;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                int weekday = (startday+j) % 7;
                if ((weekday == 5) || (weekday == 6)) continue;
                if (schedules[i] >= timelogs[i][j]) count++;
            }
            if (count == 5) answer++;
        }
        
        
        
        return answer;
    }
}