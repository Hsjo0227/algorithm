import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        
        for(int i = 0; i < M; i++) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;
            pq.offer(sum);
            pq.offer(sum);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        
        System.out.println(answer);
    }
}