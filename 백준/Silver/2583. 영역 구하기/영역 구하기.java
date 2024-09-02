import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	static int[][] board;
	static int M,N;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		board = new int[M][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int cStart = Integer.parseInt(st.nextToken());
			int rStart = Integer.parseInt(st.nextToken());
			int cEnd = Integer.parseInt(st.nextToken());
			int rEnd = Integer.parseInt(st.nextToken());
			
			for(int r = rStart; r < rEnd; r++) {
				for(int c = cStart; c < cEnd; c++) {
					board[r][c] = 1;
				}
			}
		}
		
		visited = new boolean[M][N];
		List<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 0 && !visited[i][j]) {
					int area = bfs(i, j);
					answer.add(area);
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for(int num : answer) {
			System.out.print(num + " ");
		}
	}
	public static int bfs(int r, int c) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			r = pos[0];
			c = pos[1];
			cnt++;
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= M || nc < 0 || nc >= N ) continue;
				if(board[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		return cnt;
	}
}
