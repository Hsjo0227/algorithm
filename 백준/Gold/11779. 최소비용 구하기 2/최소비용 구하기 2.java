import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int no;
        int cost;
        
        public Node(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<List<Node>> adj = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(new Node(v, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        int[] prev = new int[N+1];
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.no]) continue;
            if(cur.no == end) break;
            
            for(Node next : adj.get(cur.no)) {
                if(dist[next.no] > cur.cost + next.cost) {
                    dist[next.no] = cur.cost + next.cost;
                    pq.offer(new Node(next.no, dist[next.no]));
                    prev[next.no] = cur.no;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int cur = end;
        while(cur != start) {
            list.add(cur);
            cur = prev[cur];
        }
        list.add(cur);
        
        sb.append(dist[end]).append('\n');
        sb.append(list.size()).append('\n');
        for(int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i)).append(' ');
        }
        
        System.out.println(sb);
    }
}