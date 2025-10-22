import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[N+1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(X);
        visited[X] = true;
        int depth = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(depth == K) break;
            while(size-- > 0) {
                int num = queue.poll();
                
                for(int next : adj.get(num)) {
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            depth++;
        }
        
        if(depth == K && queue.size() != 0) {
            List<Integer> answer = new ArrayList<>();
            while(!queue.isEmpty()) answer.add(queue.poll());
            Collections.sort(answer);
            for(int num : answer) {
                sb.append(num).append('\n');
            }
        } else {
            sb.append(-1);
        }
        
        System.out.println(sb);
    }
}