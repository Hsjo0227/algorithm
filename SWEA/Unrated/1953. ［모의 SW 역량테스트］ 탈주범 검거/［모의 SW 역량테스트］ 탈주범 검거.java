import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	final static int[][] pipes = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
	
	static int N, M;
	static int[][] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			board = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			System.out.printf("#%d %d\n", tc, bfs(R, C, L));
			
		}
	}
	
	public static int bfs(int r, int c, int depth) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(++cnt == depth) break;
			
			while(--size >= 0) {
				
				int[] pos = queue.poll();
				r = pos[0];
				c = pos[1];
				int num = board[r][c];
				
				for(int pipe : pipes[num]) {
					int nr = r + dr[pipe];
					int nc = c + dc[pipe];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(!visited[nr][nc] && board[nr][nc] != 0 && isConnected(r, c, nr, nc)) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) answer++;
			}
		}
		return answer;
	}
	
	public static boolean isConnected(int r, int c, int x, int y) {
		boolean flag1 = false;
		for(int pipe: pipes[board[r][c]]) {
			int nr = r + dr[pipe];
			int nc = c + dc[pipe];
			
			if(nr == x && nc == y) {
				flag1 = true;
				break;
			}
		}
		boolean flag2 = false;
		for(int pipe: pipes[board[x][y]]) {
			int nr = x + dr[pipe];
			int nc = y + dc[pipe];
			
			if(nr == r && nc == c) {
				flag2 = true;
				break;
			}
		}
		return flag1 && flag2;
		
	}
}
