import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static long[] dp;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long n = (long) N;
        
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        
        dp = new long[N+1];
        visited = new boolean[N+1];
        
        for(int i = 0; i <= N; i++) {
            dp[i] = 1;
        }
        
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            list[start].add(end);
            list[end].add(start);
        }
        
        countChildNode(1);
        
        long answer = 0;
        for(int i = 2; i <= N; i++) {
            long M = n - dp[i];
            answer += (n * (n-1) / 2) - (M * (M-1) / 2);
        }
        
        System.out.println(answer);
    }
    
    public static long countChildNode(int no) {
        long answer = 1;
        visited[no] = true;
        for(int next : list[no]) {
            if(visited[next]) continue;
            answer += countChildNode(next);
        }
        
        dp[no] = answer;
        return answer;
    }
}