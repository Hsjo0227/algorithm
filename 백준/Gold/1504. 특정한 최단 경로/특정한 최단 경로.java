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
	static Node[] adj;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adj = new Node[N+1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[start] = new Node(end, adj[start], weight);
			adj[end] = new Node(start, adj[end], weight);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int[] stops = new int[4];
		stops[0] = 1;
		stops[1] = Integer.parseInt(st.nextToken());
		stops[2] = Integer.parseInt(st.nextToken());
		stops[3] = N;
		
		int answer = 0;
		
		int answer1 = 0;
		for(int i = 0; i < 3; i++) {
			int num = dijkstra(stops[i], stops[i+1]);
			if(num == -1) {
				answer1 = -1;
				break;
			}
			answer1 += num;
		}
		
		int temp = stops[1];
		stops[1] = stops[2];
		stops[2] = temp;
		
		int answer2 = 0;
		for(int i = 0; i < 3; i++) {
			int num = dijkstra(stops[i], stops[i+1]);
			if(num == -1) {
				answer2 = -1;
				break;
			}
			answer2 += num;
		}
		
		if(answer1 != -1 && answer2 != -1) answer = Math.min(answer1, answer2);
		else answer = Math.max(answer1, answer2);
		
		System.out.println(answer);
 		
		
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		pq.offer(new Node(start, null, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.no;
			int weight = node.weight;
			
			if(dist[idx] < weight) continue;
			
			if(idx == end) return dist[idx];
			
			for(Node n = adj[idx]; n != null; n = n.next) {
				if(weight + n.weight < dist[n.no]) {
					dist[n.no] = weight + n.weight;
					pq.offer(new Node(n.no, null, weight + n.weight));
				}
			}
		}
		
		return -1;
	}
}
