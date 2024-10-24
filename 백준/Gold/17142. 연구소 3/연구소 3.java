import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dr = {-1,1,0,0};
	static final int[] dc = {0,0,-1,1};
	
	static int N,M,answer, virusNum;
	static int[][] board, virus;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		virus = new int[10][2];
		
		virusNum = 0;
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				if(num == 2) {
					virus[virusNum++] = new int[] {i, j};
				}
				if(num != 0) cnt++;
			}
		}
		
		if(cnt == N*N) {
			System.out.println(0);
			return;
		}
		
		answer = Integer.MAX_VALUE;
		int[] combination = new int[virusNum];
		
		for(int i = 0; i < M; i++) {
			combination[virusNum-1-i] = 1;
		}
		do {
			bfs(combination);
		} while(np(combination));
		
		
		System.out.println(answer==Integer.MAX_VALUE? "-1" : answer);
	}
	
	public static void bfs(int[] combination) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		
		for(int i = 0; i < virusNum; i++) {
			if(combination[i] == 0) continue;
			int r = virus[i][0];
			int c = virus[i][1];
			queue.offer(new int[] {r, c});
			visited[r][c] = true;
		}
		
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(--size >= 0) {
				int[] pos = queue.poll();
				int r = pos[0];
				int c = pos[1];
				
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if(visited[nr][nc] || board[nr][nc] == 1) continue;
					
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
			depth++;
			
			if(countVirus(visited) == N*N) {
				answer = Math.min(answer, depth);
			}
		}
	}
	
	public static int countVirus(boolean[][] arr) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] || board[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	public static boolean np(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		if(i==0) return false;
		
		int j = arr.length-1;
		while(arr[i-1] >= arr[j]) j--;
		swap(arr, i-1, j);
		
		int k = arr.length-1;
		while(i < k) {
			swap(arr, i++, k--);
		}
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
