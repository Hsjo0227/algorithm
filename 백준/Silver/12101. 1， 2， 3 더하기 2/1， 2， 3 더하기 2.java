import java.io.*;
import java.util.*;

class Main {
    static int N, K, cnt;
    static Deque<Integer> stack;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        stack = new ArrayDeque<>();
        
        dfs(0);
        if(sb.length() == 0) sb.append(-1);
        System.out.println(sb);
    }
    
    public static boolean dfs(int sum) {
        if(sum == N) {
            cnt++;
            if(cnt != K) return false;
            
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                int num = stack.pollLast();
                sb.append(num);
                if(i != size - 1) sb.append('+');
            }
            return true;
        }
        
        for(int i = 1; i <= 3; i++) {
            if(sum + i > N) continue;
            stack.push(i);
            if(dfs(sum + i)) return true;
            stack.pop();
        }
        
        return false;
    }
}