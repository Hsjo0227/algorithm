import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	static int N, M, answer;
	static int[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	
	public static void bfs(int sr, int sc) {
		int cnt = 0;
		
		int r = sr;
		int c = sc;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		int depth = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();

			
			while(--size >= 0) {
				int[] pos = queue.poll();
				r = pos[0];
				c = pos[1];

				if(board[r][c] == 1) {
					cnt++;
				}
				
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
					}
				}
			}
			int cost = (depth * depth) + ((depth-1) * (depth-1));
			int money = (cnt * M) - cost;
			if(money >= 0) answer = Math.max(answer, cnt);
			depth++;
		}
		
	}
}
