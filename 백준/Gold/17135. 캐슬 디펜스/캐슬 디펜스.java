import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int[] dr = {0, -1, 0};
	final static int[] dc = {-1, 0, 1};
	
	static int N, M, D, cnt;
	static int[][] board;
	static List<int[]> archers;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		int[][] original = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				// 한번 끝나면 배열을 원래대로 되돌려야함
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				original[i][j] = num;
			}
		}
		// 조합을 만들기 위함
		int[] arr = new int[M];
		
		for(int i = M-1; i > M - 4; i--) {
			arr[i] = 1;
		}
		
		
		int max = 0;
		
		
		do {
			// 배열을 초기 상태로 돌림
			for(int i = 0; i < N; i++) {
				board[i] = Arrays.copyOf(original[i], M);
			}
			
			
			cnt = 0;
			for(int i = 0; i < N; i++) {
				kill(arr);
				move();
			}
			
			max = Math.max(max, cnt);
		}while(np(arr));
		
		System.out.println(max);
		
	}
	
	public static void move() {
		for(int i = N-1; i >= 1; i--) {
			board[i] = board[i-1];
		}
		board[0] = new int[M];
	}
	
	public static void kill(int[] arr) {
		archers = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			if(arr[i] == 1) {
				bfs(N-1, i);
			}
		}
		
//		System.out.println("=====================");
		for(int i = 0; i < archers.size(); i++) {
			int[] pos = archers.get(i);
//			System.out.print(Arrays.toString(pos));
			if(board[pos[0]][pos[1]] == 1) {
				cnt++;
				board[pos[0]][pos[1]] = 0;
			}
		}
//		System.out.println();
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
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
					archers.add(new int[] {r,c});
					return;
				}
				
				for(int i = 0; i < 3; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
			if(depth >= D) break;
			depth++;
		}
	}
	
	public static boolean np(int[] arr) {
		
		int i = M-1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = M-1;
		while(arr[i-1] >= arr[j]) j--;
		
		swap(i-1, j, arr);
		
		int k = M-1;
		while(i < k) {
			swap(i++, k--, arr);
		}
		
		return true;
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
