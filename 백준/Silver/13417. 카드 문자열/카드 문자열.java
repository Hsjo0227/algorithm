import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            Deque<Character> deque = new ArrayDeque<>();
            
            String str = br.readLine();
            
            
            deque.offer(str.charAt(0));
            
            for(int i = 1; i < N; i++) {
                char first = deque.peekFirst();
                
                char now = str.charAt(2 * i);
                
                if(now <= first) {
                    deque.offerFirst(now);
                } else {
                    deque.offerLast(now);
                }
            }
            
            for(int i = 0; i < N; i++) {
                sb.append(deque.pollFirst());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}