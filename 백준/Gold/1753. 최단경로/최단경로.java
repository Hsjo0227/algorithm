import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Vertex {
		int no;
		Vertex next;
		int weight;
		
		public Vertex(int no, Vertex next, int weight) {
			super();
			this.no = no;
			this.next = next;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine())-1;
		
		Vertex[] adj = new Vertex[V];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			Vertex vertex = new Vertex(end, adj[start], weight);
			adj[start] = vertex;
		}
		
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		int cnt = 1;
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		while(cnt < V) {
			int minVertexNo = 0;
			int min = Integer.MAX_VALUE;
			// 방문하지 않은 거리가 최소인 정점 선택
			for(int i = 0; i < V; i++) {
				if(!visited[i] && min > dist[i]) {
					min = dist[i];
					minVertexNo = i;
				}
			}
			
			visited[minVertexNo] = true;
			
			for(Vertex vertex = adj[minVertexNo]; vertex != null; vertex = vertex.next) {
				if(!visited[vertex.no] && dist[vertex.no] > dist[minVertexNo] + vertex.weight) {
					dist[vertex.no] = dist[minVertexNo] + vertex.weight;
				}
			}
			cnt++;
		}
		for(int i = 0; i < V; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE? "INF" : dist[i]);
		}
	}
}
