import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		
	}
	static int N, M, W;
	static List<Edge> edges;
	static final int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int t = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(s, e, t));
				edges.add(new Edge(e, s, t));
			}
			
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int t = Integer.parseInt(st.nextToken());

				edges.add(new Edge(s, e, -t));
			}
			
			if(bellmanFord()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
		}
		System.out.print(sb);
	}
	
	public static boolean bellmanFord() {
		// 음의 사이클을 확인했는지 
		boolean[] checked = new boolean[N];
		int[] dist = new int[N];
		
		for(int start = 0; start < N; start++) {
			// 이미 음의 사이클을 확인함
			if(checked[start]) continue;
			
			Arrays.fill(dist, INF);
			dist[start] = 0;
			checked[start] = true;
			
			for(int i = 0; i < N-1; i++) {
				for(Edge edge : edges) {
					if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
						dist[edge.to] = dist[edge.from] + edge.weight;
						checked[edge.to] = true;
					}
				}
			}
			
			for(Edge edge : edges) {
				if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
					return true;
				}
			}
			
		}
		return false;
	}
}
