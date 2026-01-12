import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }
        
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            int idx = 0;
            for(int num : deque) {
                if(num == target) break;
                idx++;
            }
            
            int size = deque.size();
            
            if(idx <= size / 2) {
                for(int j = 0; j < idx; j++) {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
            } else {
                for(int j = 0; j < size - idx; j++) {
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(answer);
    }
}