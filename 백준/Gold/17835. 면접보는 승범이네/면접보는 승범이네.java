import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int idx;
        long cost;
        
        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        public int compareTo(Node node) {
            if(this.cost == node.cost) return Integer.compare(this.idx, node.idx);
            else return Long.compare(this.cost, node.cost);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<List<Node>> adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());
            
            adj.get(v).add(new Node(u, c));
        }
        
        long[] dist = new long[N+1];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.offer(new Node(num, 0));
            dist[num] = 0;
        }
        
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.idx]) continue;
            
            for(Node next : adj.get(cur.idx)) {
                if(dist[next.idx] > dist[cur.idx] + next.cost) {
                    dist[next.idx] = dist[cur.idx] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
            
        }
        
        int city = 0;
        long maxDist = 0;
        
        for(int i = N; i >= 1; i--) {
            if(dist[i] >= maxDist) {
                maxDist = dist[i];
                city = i;
            }
        }
        
        System.out.println(city);
        System.out.println(maxDist);
        
    }
}