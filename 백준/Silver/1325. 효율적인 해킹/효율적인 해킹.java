import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> adj;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj.get(v).add(u);
        }
        
        int[] count = new int[N+1];
        int max = 0;
        
        for(int i = 1; i <= N; i++) {
            int num = bfs(i);
            count[i] = num;
            max = Math.max(max, num);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(count[i] == max) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
    static int bfs(int start) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        visited[start] = true;
        queue.offer(start);
        
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : adj.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}