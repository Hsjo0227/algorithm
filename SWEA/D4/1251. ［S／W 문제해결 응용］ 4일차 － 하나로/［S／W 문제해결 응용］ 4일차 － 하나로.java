import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Vertex implements Comparable<Vertex> {
		int no;
		Vertex next;
		long weight;
		
		public Vertex(int no, Vertex next, long weight) {
			super();
			this.no = no;
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.weight, o.weight);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Vertex[] adj = new Vertex[N];
			long[] inputX = new long[N];
			long[] inputY = new long[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				inputX[i] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inputY[i] = Long.parseLong(st.nextToken());
			}
			// 세율
			double E = Double.parseDouble(br.readLine());
			
			// 현재 상태에서 트리에서 가장 가까운 노드부터 나옴
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			// 트리에 포함되어 있는지 여부
			boolean[] visited = new boolean[N];
			// 각 노드까지의 최소 간선 비용
			long[] minEdge = new long[N];
			
			
			// 인접리스트에 거리 구해서 노드 추가, minEdge배열을 MAX_VALUE로 초기화
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					long dx = inputX[i] - inputX[j];
					long dy = inputY[i] - inputY[j];
					long distance = dx*dx + dy*dy;
					
					Vertex vertex = new Vertex(j, adj[i], distance);
					adj[i] = vertex;
					
					vertex = new Vertex(i, adj[j], distance);
					adj[j] = vertex;
				}
				minEdge[i] = Long.MAX_VALUE;
			}
			
			double answer = 0;
			int cnt = 0;
			minEdge[0] = 0;
			pq.offer(new Vertex(0, null, minEdge[0]));
			
			while(!pq.isEmpty()) {
				// 최소 거리의 노드를 확인
				Vertex minVertex = pq.poll();
				// 트리에 이미 있으면 다음으로
				if(visited[minVertex.no]) continue;
				
				// 없으면 추가
				answer += minVertex.weight * E;
				visited[minVertex.no] = true;
				if(++cnt == N) break;
				
				for(Vertex vertex = adj[minVertex.no]; vertex != null; vertex = vertex.next) {
					if(!visited[vertex.no] && minEdge[vertex.no] > vertex.weight) {
						minEdge[vertex.no] = vertex.weight;
						pq.offer(new Vertex(vertex.no, null, minEdge[vertex.no]));
					}
				}
				
			}
			System.out.printf("#%d %d\n", tc, Math.round(answer));
		}
	}
}
