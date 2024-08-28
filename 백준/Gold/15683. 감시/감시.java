import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 상부터 시계방향으로 상, 우, 하, 좌 순서
	final static int[] dr = {-1, 0, 1, 0};
	final static int[] dc = {0, 1, 0, -1};
	
	static int N, M;
	static int[][] board;
	static List<Camera> cameras;
	static int answer;
	
	static class Camera {
		int r;
		int c;
		int type;
		
		public Camera(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		cameras = new ArrayList<>();
		
		// 사각지대의 개수와 위치(비트 마스킹)
		int blindSpot = N * M;
		int[] area = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				if(1 <= num && num <= 5) {
					cameras.add(new Camera(i, j, num));
					blindSpot--;
					area[i] |= (1<<j);
				}
				if(num == 6) {
					blindSpot--;
					area[i] |= (1<<j);
				}
			}
		}
		
		// 5번 카메라 사방으로 먼저 표시
		for(int i = cameras.size()-1; i >= 0; i--) {
			Camera camera = cameras.get(i);
			if(camera.type == 5) {
				see(camera.r, camera.c, 0, 5, area);
				cameras.remove(i);
				i--;
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		dfs(0, area);
		
		System.out.println(answer);
		
		
		
	}
	
	public static void dfs(int index, int[] area) {
		if(index >= cameras.size()) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if((area[i] & (1<<j)) == 0) cnt++;
				}
			}
			answer = Math.min(answer, cnt);
			return;
		}
		Camera camera = cameras.get(index);
		for(int i = 0; i < 4; i++) {
			int[] copy = Arrays.copyOf(area, N);
			see(camera.r, camera.c, i, camera.type, copy);
			dfs(index+1,copy);
		}
	}
	
	public static void see(int r, int c, int rotate, int type, int[] area) {
		int dir;
		int nr;
		int nc;
		
		switch(type) {
		case 1:
			dir = rotate;
			nr = r + dr[dir];
			nc = c + dc[dir];
			while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(board[nr][nc] == 6) break;
				area[nr] |= (1<<nc);
				
				nr = nr + dr[dir];
				nc = nc + dc[dir];
			}
			
			break;
		case 2:
			dir = rotate;
			nr = r + dr[dir];
			nc = c + dc[dir];
			while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(board[nr][nc] == 6) break;
				area[nr] |= (1<<nc);
				
				nr = nr + dr[dir];
				nc = nc + dc[dir];
			}
			// 반대 방향
			dir = (rotate + 2) % 4;
			
			nr = r + dr[dir];
			nc = c + dc[dir];
			while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(board[nr][nc] == 6) break;
				area[nr] |= (1<<nc);
				
				nr = nr + dr[dir];
				nc = nc + dc[dir];
			}
			
			break;
		case 3:
			for(int i = 0; i < 2; i++) {
				dir = (rotate+i)%4;
				
				nr = r + dr[dir];
				nc = c + dc[dir];
				while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(board[nr][nc] == 6) break;
					area[nr] |= (1<<nc);
					
					nr = nr + dr[dir];
					nc = nc + dc[dir];
				}
			}
			
			break;
		case 4:
			for(int i = 0; i < 3; i++) {
				dir = (rotate+i)%4;
				
				nr = r + dr[dir];
				nc = c + dc[dir];
				while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(board[nr][nc] == 6) break;
					area[nr] |= (1<<nc);
					
					nr = nr + dr[dir];
					nc = nc + dc[dir];
				}
			}
			
			break;
		case 5:
			for(int i = 0; i < 4; i++) {
				dir = (rotate+i)%4;
				
				nr = r + dr[dir];
				nc = c + dc[dir];
				while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(board[nr][nc] == 6) break;
					area[nr] |= (1<<nc);
					
					nr = nr + dr[dir];
					nc = nc + dc[dir];
				}
			}
			
			break;
		}
	}
}
