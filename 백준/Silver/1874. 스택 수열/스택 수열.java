import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        int last = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(last > num) {
                if(deque.peek() != num) {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                } else {
                    deque.pop();
                    sb.append('-').append('\n');
                }
            } else {
                for(int j = last+1; j <= num; j++) {
                    deque.push(j);
                    sb.append('+').append('\n');
                }
                deque.pop();
                sb.append('-').append('\n');
                last = num;
            }
        }
        System.out.print(sb);
    }
}