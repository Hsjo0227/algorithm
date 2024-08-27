import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	final static int[] dr = {-1, 1, 0 ,0};
	final static int[] dc = {0, 0, -1 ,1};
	
	static int N;
	static int cnt, colorBlindCnt;
	static int[][] board;
	static int[][] colorBlind;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		colorBlind = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				char ch = str.charAt(j);
			
				if(ch == 'R') {
					board[i][j] = 0;
					colorBlind[i][j] = 0;
				} else if(ch == 'G') {
					board[i][j] = 1;
					colorBlind[i][j] = 0;
				} else if(ch == 'B') {
					board[i][j] = 2;
					colorBlind[i][j] = 1;
				}
			}
		}
		visited = new boolean[N][N];
		cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt++;
					bfs(i, j, board);
				}
			}
		}
		
		visited = new boolean[N][N];
		colorBlindCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					colorBlindCnt++;
					bfs(i, j, colorBlind);
				}
			}
		}
		System.out.printf("%d %d", cnt, colorBlindCnt);
	}
	
	public static void bfs(int r, int c, int[][] arr) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		int num = arr[r][c];
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			r = pos[0];
			c = pos[1];
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(arr[nr][nc] == num) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
