import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[N+1];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            int start = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num - 1; j++) {
                int end = Integer.parseInt(st.nextToken());
                
                inDegree[end]++;
                adj.get(start).add(end);
                
                start = end;
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            answer.add(cur);
            
            for(int next : adj.get(cur)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        if(answer.size() != N) {
            System.out.println(0);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num).append('\n');
        }
        
        System.out.println(sb);
        
    }
}