import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        
        System.out.println(solve());
        StringBuilder sb = new StringBuilder();
        for(int i = N; i > 0; i = parent[i]) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    public static int solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int num = queue.poll();
                if(num == N) return depth;
                if(num+1 <= N && parent[num+1] == 0) {
                    parent[num+1] = num;
                    queue.offer(num+1);
                }
                if(num*2 <= N && parent[num*2] == 0) {
                    parent[num*2] = num;
                    queue.offer(num*2);
                }
                if(num*3 <= N && parent[num*3] == 0) {
                    parent[num*3] = num;
                    queue.offer(num*3);
                }
            }
            depth++;
        }
        return -1;
    }
}