import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		long cost;
		
		public Edge(int start, int end, long cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
		
		
	}
	static int N, M;
	static int[] parents;
	static int set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		makeSet();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(start, end, cost));
		}
		
		set = N;
		long answer = 0;
		while(set > 2) {
			Edge edge = pq.poll();
			if(union(edge.start, edge.end)) {
				answer += edge.cost;
				set--;
			}
			
		}
		
		System.out.println(answer);
		
		
	}
	
	public static void makeSet() {
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		
		else return parents[a] =  find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) return false;
		
		parents[parentA] = parentB;
		return true;
		
	}
}
