import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static Node[] adj;
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
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			adj = new Node[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < input/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				Node node = new Node(to, adj[from]);
				adj[from] = node;
			}
			
			System.out.printf("#%d %d\n", tc, bfs(start));
			
			
		}
		

	}
	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[101];
		queue.offer(start);
		visited[start] = true;
		int max = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			max = 0;
			while(size-- > 0) {
				int num = queue.poll();
				max = Math.max(max, num);
				
				for(Node node = adj[num]; node != null; node = node.next) {
					if(visited[node.number]) continue;
					queue.offer(node.number);
					visited[node.number] = true;
				}
			}
		}
		
		return max;
	}

}
