import java.io.*;
import java.util.*;


class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i = 0; i < 10; i++) {
            pq.offer(i);
        }
        
        cnt = 0;
        while(!pq.isEmpty()) {
            long num = pq.poll();
            
            if(++cnt == N) {
                System.out.println(num);
                return;
            }
            
            long digit = num % 10;
            
            for(int i = 0; i < digit; i++) {
                long next = num * 10 + i;
                pq.offer(next);
            }
        }
        
        System.out.println(-1);
    }
}