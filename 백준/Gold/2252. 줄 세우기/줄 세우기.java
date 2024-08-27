import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int number;
		Node next;
		
		public Node(int number, Node next) {
			super();
			this.number = number;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] adj = new Node[N+1];
		int[] inDegree = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			Node node = new Node(to, adj[from]);
			adj[from] = node;
			inDegree[to]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int num = queue.poll();

			sb.append(num).append(" ");
			for(Node node = adj[num]; node != null; node = node.next) {
				inDegree[node.number]--;
			}
			
			for(Node node = adj[num]; node != null; node = node.next) {
				if(inDegree[node.number] == 0) {
					if(!visited[node.number] && inDegree[node.number] == 0) {
						queue.offer(node.number);
						visited[node.number] = true;
					}	
				}
			}
		}
		
		System.out.println(sb);
	}
}
