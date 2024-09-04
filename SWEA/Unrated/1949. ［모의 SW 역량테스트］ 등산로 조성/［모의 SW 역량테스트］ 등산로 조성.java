import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	static List<int[]> list;
	static int N, K;
	static int[][] board;
	static int[][] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			answer = new int[N][N];
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, board[i][j]);
				}
			}
			
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == max) {
						list.add(new int[] {i, j});
						answer[i][j] = 1;
					}
				}
			}
			
			int b = 0;
			for(int[] pos: list) {
				b = bfs(pos[0], pos[1]);
			}
			
			int a = function();
			System.out.printf("#%d %d\n", tc, Math.max(a, b));
		}
	}
	
	public static int bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] answer = new int[N][N];
		queue.offer(new int[] {r, c});
		
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(--size >= 0) {
				int[] pos = queue.poll();
				r = pos[0];
				c = pos[1];
				
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if(board[r][c] > board[nr][nc]) {
						queue.offer(new int[] {nr, nc});
						answer[nr][nc] = Math.max(answer[nr][nc], answer[r][c]+1);
					}
				}
			}
			
			depth++;
		}
		return depth;
	}
	
	public static int function() {
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < K; k++) {
					board[i][j] = board[i][j] - 1;
					int num = 0;
					for(int[] pos: list) {
						if(pos[0] == i && pos[1] == j) continue;
						num = Math.max(num, bfs(pos[0], pos[1]));
					}
					if(max < num) {
						max = num;
					}
				}
				board[i][j] = board[i][j] + K;
			}
		}
		
		return max;
	}
	
}
