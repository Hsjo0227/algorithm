import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(left.size() == right.size()) left.offer(num);
            else if(left.size() > right.size()) right.offer(num);
            
            if(left.size() != 0 && right.size() != 0) {
                while(left.peek() > right.peek()) {
                    int temp = left.poll();
                    left.offer(right.poll());
                    right.offer(temp);
                }
            }
            sb.append(left.peek()).append('\n');
        }
        System.out.println(sb);
    }
}