import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return -Integer.compare(o1[0], o2[0]);
                }
                return -Integer.compare(o1[1], o2[1]);
            }
        });
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {day, score});
            
        }
        
        int answer = 0;
        int[] days = new int[10000];
        while(!pq.isEmpty()) {
            int[] problem = pq.poll();
            int day = problem[0];
            int point = problem[1];
            
            for(int i = day-1; i >= 0; i--) {
                if(days[i] == 0) {
                    days[i] = point;
                    answer += point;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}