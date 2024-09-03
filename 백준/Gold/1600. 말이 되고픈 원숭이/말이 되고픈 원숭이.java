import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 안돼....
public class Main {
	final static int[] dr = {-2, -1, 1, 2,  2,  1, -1, -2, -1, 1, 0, 0};
	final static int[] dc = { 1,  2, 2, 1, -1, -2, -2, -1, 0, 0, -1, 1};
	
	static int W, H, K, answer;
	static int[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		System.out.println(bfs(0, 0));
	}
	
	public static int bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[H][W][K+1];
		
		queue.offer(new int[] {r, c, 0});
		visited[r][c][0] = true;
		
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(--size >= 0) {
				int[] pos = queue.poll();
				r = pos[0];
				c = pos[1];
				int k = pos[2];
				
				if(r == H-1 && c == W-1) return depth;
				
				if(k < K) {
					// 말의 움직임
					for(int i = 0; i < 8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
						
						if(!visited[nr][nc][k+1] && board[nr][nc] == 0) {
							visited[nr][nc][k+1] = true;
							queue.offer(new int[] {nr, nc, k+1});
						}
					}
				}
				
				// 원숭이의 움직임
				for(int i = 8; i < 12; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					
					if(!visited[nr][nc][k] && board[nr][nc] == 0) {
						visited[nr][nc][k] = true;
						queue.offer(new int[] {nr, nc, k});
					}
				}
			}
			depth++;
		}
		
		return -1;
	}

}
