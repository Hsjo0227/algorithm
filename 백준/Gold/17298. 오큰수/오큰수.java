import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] input = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
        }
        
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++) {
            int num = input[i];
            while(!stack.isEmpty() && input[stack.peek()] < input[i]) {
                int idx = stack.pop();
                answer[idx] = input[i];
            }
            stack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(answer[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}