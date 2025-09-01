import java.io.*;
import java.util.*;

class Main {
    static class Homework implements Comparable<Homework>{
        int time;
        int cost;
        
        public Homework(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Homework h) {
            if(this.cost == h.cost) return Integer.compare(this.time, h.time);
            else return -Integer.compare(this.cost, h.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Homework> homeworks = new PriorityQueue<>(Comparator.comparingInt(h -> h.time));
            
            PriorityQueue<Homework> pq = new PriorityQueue<>();
            
            st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++) {
                int time = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st2.nextToken());
                if(time <= S) {
                    pq.offer(new Homework(time, cost));
                } else {
                    homeworks.offer(new Homework(time, cost));
                }
            }
            
            int t = S;
            long answer = 0;
            
            while(!pq.isEmpty() || !homeworks.isEmpty()) {
                if(!pq.isEmpty()) {
                    Homework h = pq.poll();
                    long overTime = Math.max(t - h.time, 0);
                    
                    answer += overTime * h.cost;
                    t++;
                }
                
                Homework next = homeworks.peek();
                if(next == null) continue;
                if(pq.isEmpty()) t = next.time;
                
                while(next != null && next.time <= t) {
                    pq.offer(next);
                    homeworks.poll();
                    next = homeworks.peek();
                }
            }
            sb.append(answer).append('\n');
        }
        
        System.out.println(sb);
    }
}