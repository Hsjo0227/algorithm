import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int no;
		Node next;
		int weight;
		
		public Node(int no, Node next, int weight) {
			super();
			this.no = no;
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		
		Node[] adj = new Node[N];
		Node[] reverseAdj = new Node[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			adj[start] = new Node(end, adj[start], weight);
			reverseAdj[end] = new Node(start, reverseAdj[end], weight);
		}
		
		int[] dist1 = dijkstra(X, reverseAdj);
		int[] dist2 = dijkstra(X, adj);
		
		int max = 0;
 		for(int i = 0; i < N; i++) {
 			max = Math.max(max, dist1[i] + dist2[i]);
 		}
		
 		System.out.println(max);
	}
	
	public static int[] dijkstra(int start, Node[] adj) {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, null, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int idx = current.no;
			int weight = current.weight;
			
			if(dist[idx] < weight) continue;
			
			for(Node node = adj[idx]; node != null; node = node.next) {
				if(weight + node.weight < dist[node.no]) {
					dist[node.no] = weight + node.weight;
					pq.offer(new Node(node.no,null, weight + node.weight));
				}
			}
		}
		return dist;
	}

}
