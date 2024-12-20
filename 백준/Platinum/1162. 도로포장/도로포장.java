import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int no;
        long weight;
        Node next;
        int paved;
        
        public Node(int no, long weight, int paved, Node next) {
            this.no = no;
            this.weight = weight;
            this.paved = paved;
            this.next = next;
        }

		@Override
		public int compareTo(Node o) {
			if(this.weight == o.weight) {
				return Integer.compare(this.paved, o.paved);
			}
            return Long.compare(this.weight, o.weight);
		}
    }
    
    
    static final long INF = Long.MAX_VALUE/2;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Node[] adj = new Node[N+1];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            
            adj[start] = new Node(end, weight, 0, adj[start]);
            adj[end] = new Node(start, weight, 0, adj[end]);
        }
        
        long[][] dist = new long[N+1][K+1];
        
        for(int i = 0; i <= N; i++) {
        	Arrays.fill(dist[i], INF);
        }
        dist[1][0] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0, null));
        
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	int cur = node.no;
        	long weight = node.weight;
        	int paved = node.paved;
        	
        	if(cur == N) {
        		System.out.println(weight);
        		return;
        	}
        	
        	if(weight > dist[cur][paved]) continue;
        	
        	for(Node n = adj[cur]; n != null; n = n.next) {
        		int next = n.no;
        		long nextWeight = weight + n.weight;
        		
        		if(nextWeight < dist[next][paved]) {
        			dist[next][paved] = nextWeight;
        			pq.offer(new Node(next, nextWeight, paved, null));
        		}
        		
        		if(paved < K && weight < dist[next][paved+1]) {
        			dist[next][paved+1] = weight;
        			pq.offer(new Node(next, weight, paved+1, null));
        		}
        	}
        	
        }
        
        
    }
}