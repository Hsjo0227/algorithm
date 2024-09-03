import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(N != 0) {
			final int INF = Integer.MAX_VALUE;
			int[][] board = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			int[][] minCost = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					minCost[i][j] = INF;
				}
			}
			
			minCost[0][0] = board[0][0];
			pq.offer(new int[] {0, 0, minCost[0][0]});
			
			while(!pq.isEmpty()) {
				int[] vertex = pq.poll();
				int r = vertex[0];
				int c = vertex[1];
				int weight = vertex[2];
				
				if(visited[r][c]) continue;
				visited[r][c] = true;
				
				if(r == N-1 && c == N-1) break;
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					
					if(!visited[nr][nc] && minCost[nr][nc] > weight + board[nr][nc]) {
						minCost[nr][nc] = weight + board[nr][nc];
						pq.offer(new int[] {nr, nc, minCost[nr][nc]});
					}
				}
			}
			
			
			sb.append("Problem ").append(cnt++).append(": ").append(minCost[N-1][N-1]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.print(sb);
	}
}
