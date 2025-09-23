import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] trucks = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Integer> queue = new ArrayDeque<>(w);
        for(int i = 0; i < w; i++) {
            queue.offer(0);
        }
        
        int sum = 0;
        int idx = 0;
        int answer = 0;
        
        while(idx < n) {
            
            sum -= queue.poll();
            
            if(sum + trucks[idx] <= L) {
                sum += trucks[idx];
                queue.offer(trucks[idx]);
                idx++;
            } else {
                queue.offer(0);
            }
            answer++;
        }
        
        System.out.println(answer + w);
        
    }
}