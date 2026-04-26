import java.util.*;

class Solution {
    static class Task {
        String name;
        int time;
        
        Task(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
    
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        int idx = 0;
        
        Arrays.sort(plans, (arr1, arr2) -> {
            return arr1[1].compareTo(arr2[1]);
        });
        
        Deque<Task> deque = new ArrayDeque<>();
        
        for(int i = 0; i < N - 1; i++) {
            String name = plans[i][0];
            int start = convert(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            int nextStart = convert(plans[i+1][1]);
            int interval = nextStart - start;
            
            if(playTime <= interval) {
                answer[idx++] = name;
                
                int rest = interval - playTime;
                
                while(rest > 0 && !deque.isEmpty()) {
                    Task before = deque.pollLast();
                    
                    if(before.time <= rest) {
                        rest -= before.time;
                        answer[idx++] = before.name;
                    } else {
                        before.time -= rest;
                        deque.offerLast(before);
                        rest = 0;
                    }
                }
            } else {
                int remain = playTime - interval;
                deque.offerLast(new Task(name, remain));
            }
        }
        
        answer[idx++] = plans[N-1][0];
        
        while(!deque.isEmpty()) {
            answer[idx++] = deque.pollLast().name;
        }
        
        return answer;
    }
    
    private int convert(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        return hour * 60 + minute;
    }
}