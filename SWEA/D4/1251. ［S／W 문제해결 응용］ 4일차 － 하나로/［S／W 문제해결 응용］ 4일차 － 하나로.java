import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] parents;
	
	public static void make() {
		parents = new int[N];
		Arrays.fill(parents, -1);
	}
	
	public static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int start, end;
		double weight;

		public Edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int E = N * (N-1) / 2;
			
			long[] islandX = new long[N];
			long[] islandY = new long[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				islandX[i] = Long.parseLong(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				islandY[i] = Long.parseLong(st.nextToken());
			}
			
			Edge[] edges = new Edge[E];
			
			int idx = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					long dx = islandX[i] - islandX[j];
					long dy = islandY[i] - islandY[j];
					double weight = (double)(dx * dx + dy * dy);
					edges[idx++] = new Edge(i, j, weight);
				}
			}
			
			make();
			Arrays.sort(edges);
			
			int cnt = 0;
			double sum = 0;
			for(Edge edge : edges) {
				if(union(edge.start, edge.end)) {
					sum += edge.weight;
					if(cnt == N - 1) break;
				}
			}
			
			double ratio = Double.parseDouble(br.readLine());
			
			long answer = Math.round(ratio * sum);
			
			System.out.println("#" + tc + " " + answer);
			
		}
	}

}
