import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	static int N,L,R;
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = true;
		int day = 0;
		while(flag) {
			visited = new boolean[N][N];
			flag = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						flag = bfs(i, j) || flag;
					}
				}
			}
			if(flag == false) break;
			day++;
		}
		
		System.out.println(day);
		
	}
	
	private static boolean bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> queue2 = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		int count = 0;
		int sum = 0;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			queue2.offer(pos);
			r = pos[0];
			c = pos[1];
			
			count++;
			sum += board[r][c];

			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(!visited[nr][nc]) {
					int diff = Math.abs(board[r][c] - board[nr][nc]);
					if(diff >= L && diff <= R) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}

		int avg = sum / count;
		
		while(!queue2.isEmpty()) {
			int[] pos = queue2.poll();
			r = pos[0];
			c = pos[1];
			
			board[r][c] = avg;
		}
		
		if(count > 1) return true;
		else return false;
	}

}