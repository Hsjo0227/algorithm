import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        List<List<Edge>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.offer(new int[] {s, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int distance = cur[1];
            
            if(visited[u]) continue;
            visited[u] = true;
            if(u == t) {
                System.out.println(distance);
                return;
            }
            
            for(Edge e : adj.get(u)) {
                int v = e.to;
                int num = distance + e.w;
                if(num < dist[v]) {
                    dist[v] = num;
                    pq.offer(new int[]{v, num});
                }
            }
        }
    }
}