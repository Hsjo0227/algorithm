import java.util.*;

class Solution {
    static class Task implements Comparable<Task> {
        int no;
        int arriveTime;
        int takeTime;
        
        public Task(int no, int arriveTime, int takeTime) {
            this.no = no;
            this.arriveTime = arriveTime;
            this.takeTime = takeTime;
        }
        
        public int compareTo(Task t) {
            if(this.takeTime != t.takeTime) {
                return Integer.compare(this.takeTime, t.takeTime);
            } else if(this.arriveTime != t.arriveTime) {
                return Integer.compare(this.arriveTime, t.arriveTime);
            } else {
                return Integer.compare(this.no, t.no);
            }
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        
        List<Task> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        list.sort((o1, o2) -> Integer.compare(o1.arriveTime, o2.arriveTime));
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        int time = 0;
        int idx = 0;
        
        while(idx < n || !pq.isEmpty()) {
            System.out.println(idx);
            while(idx < n && list.get(idx).arriveTime <= time) {
                pq.offer(list.get(idx++));
            }
            
            if(pq.isEmpty()) {
                time = list.get(idx).arriveTime;
                continue;
            }
            
            Task task = pq.poll();
            time += task.takeTime;
            answer += time - task.arriveTime;
        }
        
        return answer / n;
    }
}