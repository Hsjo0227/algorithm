import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int answer = 0;
        while((pq.size()) != 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            int num = num1 + num2;
            answer += num;
            pq.offer(num);
        }
        
        System.out.println(answer);
    }
}