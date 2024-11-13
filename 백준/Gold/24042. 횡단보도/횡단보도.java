import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		long cost;
		Node next;
		public Node(int num, long cost, Node next) {
			super();
			this.num = num;
			this.cost = cost;
			this.next = next;
		}
	}
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		long time;
		
		public Edge(int start, int end, long time) {
			super();
			this.start = start;
			this.end = end;
			this.time = time;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.time, o.time);
		}
	}
	
	static final long INF = Long.MAX_VALUE/2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] adj = new Node[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adj[start] = new Node(end, i, adj[start]);
			adj[end] = new Node(start, i, adj[end]);
		}
		
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		
		dist[1] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,1,0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int end = edge.end;
			
			if(edge.time > dist[end]) continue;
			
			for(Node node = adj[edge.end]; node != null; node = node.next) {
				long waitTime = (node.cost - (edge.time % M) + M) % M;
                long totalTime = edge.time + waitTime + 1; 
                
				if(totalTime < dist[node.num]) {
					dist[node.num] = totalTime;
					pq.offer(new Edge(edge.end, node.num, totalTime));
				}
			}
		}
		System.out.println(dist[N]);
	}

}
