import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node>{
        int u;
        long cost;
        int max;
        
        public Node(int u, long cost, int max) {
            this.u = u;
            this.cost = cost;
            this.max = max;
        }
        
        public int compareTo(Node n) {
            return Integer.compare(this.max, n.max);
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 두번째는 비용, 세번째는 경로의 최대 비용
        pq.offer(new Node(A, 0, 0));
        dist[A] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            int u = cur.u;
            long cost = cur.cost;
            int max = cur.max;
            
            if(max > dist[u]) continue;
            if(u == B) break;
            
            for(int[] next : adj.get(u)) {
                int v = next[0];
                int w = next[1];
                
                long newCost = cost + w;
                if(newCost > C) continue;
                
                int newMax = Math.max(max, w);
                if(newMax < dist[v]) {
                    dist[v] = newMax;
                    pq.offer(new Node(v, newCost, newMax));
                }
            }
        }
        
        if(dist[B] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist[B]);
    }
}