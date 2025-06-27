import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            for(int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            
            long answer = 0;
            while(pq.size() >= 2) {
                long file1 = pq.poll();
                long file2 = pq.poll();
                
                long tempFile = file1 + file2;
                answer += tempFile;
                pq.offer(tempFile);
            }
            
            System.out.println(answer);
        }
        
    }
}