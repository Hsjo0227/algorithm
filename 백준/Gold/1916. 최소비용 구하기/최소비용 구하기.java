import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            
        }
        
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new int[] {end, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (int[] arr1, int[] arr2) -> Integer.compare(arr1[1], arr2[1])
        );
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE/2);
        
        queue.offer(new int[] {start, 0});
        cost[start] = 0;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int current = arr[0];
            int currentCost = arr[1];
            
            if(current == end) break;
            
            for(int[] next : adj.get(current)) {
                if(cost[current] + next[1] < cost[next[0]]) {
                    queue.offer(new int[] {next[0], cost[current] + next[1]});
                    cost[next[0]] = cost[current] + next[1];
                }
            }
        }
        
        System.out.println(cost[end]);
        
    }
}