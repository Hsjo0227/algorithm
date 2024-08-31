import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int[] minEdge;
	static PriorityQueue<Vertex> pq;
	static Vertex[] adj;
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		Vertex next;
		int weight;
		public Vertex(int no, Vertex next, int weight) {
			super();
			this.no = no;
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			adj = new Vertex[V];
			visited = new boolean[V];
			
			minEdge = new int[V];
			pq = new PriorityQueue<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				Vertex vertex = new Vertex(end, adj[start], weight);
				adj[start] = vertex;
				

				vertex = new Vertex(start, adj[end], weight);
				adj[end] = vertex;
			}
			for(int i = 0; i < V; i++) {
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			long answer = 0;
			int cnt = 0;
			minEdge[0] = 0;
			pq.offer(new Vertex(0, null, minEdge[0]));
			
			while(!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if(visited[minVertex.no]) continue;
				
				answer += minVertex.weight;
				visited[minVertex.no] = true;
				if(++cnt == V) break;
				
				for(Vertex vertex = adj[minVertex.no]; vertex != null; vertex = vertex.next) {
					if(!visited[vertex.no] && minEdge[vertex.no] > vertex.weight) {
						minEdge[vertex.no] = vertex.weight;
						pq.offer(new Vertex(vertex.no, null, minEdge[vertex.no]));
					}
				}
			}
			
			System.out.println("#" + tc +" "+answer);
		}
	}
}
