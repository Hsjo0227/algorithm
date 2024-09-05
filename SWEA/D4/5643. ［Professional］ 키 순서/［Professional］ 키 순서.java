import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		int no;
		Node next;
		
		public Node(int no, Node next) {
			super();
			this.no = no;
			this.next = next;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			Node[] adj = new Node[N];
			Node[] adjReverse = new Node[N];
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				
				adj[start] = new Node(end, adj[start]);
				adjReverse[end] = new Node(start, adjReverse[end]);
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				boolean[] visited = new boolean[N];
				visited[i] = true;
				Queue<Integer> queue = new ArrayDeque<>();
				queue.offer(i);
				while(!queue.isEmpty()) {
					int num = queue.poll();
					for(Node node = adj[num]; node != null; node = node.next) {
						if(!visited[node.no]) {
							visited[node.no] = true;
							queue.offer(node.no);
						}
					}
				}
				queue.offer(i);
				while(!queue.isEmpty()) {
					int num = queue.poll();
					for(Node node = adjReverse[num]; node != null; node = node.next) {
						if(!visited[node.no]) {
							visited[node.no] = true;
							queue.offer(node.no);
						}
					}
				}
				boolean a = true;
				for(int j = 0; j < N; j++) {
					a = a && visited[j];
				}
				if(a) cnt++;
			}
			
			System.out.printf("#%d %d\n",tc, cnt);
		}
	}
}
