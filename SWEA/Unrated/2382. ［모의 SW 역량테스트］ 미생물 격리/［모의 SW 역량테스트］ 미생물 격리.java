import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	// {x, 상, 하, 좌, 우} 순서
	final static int[] dr = {0, -1, 1, 0, 0};
	final static int[] dc = {0, 0, 0, -1, 1};
	
	static class Virus {
		// 미생물의 수
		int total;
		// 군집의 방향
		int direction;
		// 해당 위치에서 가장 강한 군집의 미생물 수
		int max;
		
		public Virus(int total, int direction, int max) {
			super();
			this.total = total;
			this.direction = direction;
			this.max = max;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			
			Virus[][] board = new Virus[N][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				Virus virus = new Virus(num, dir, num);
				board[r][c] = virus;
			}
			
			
			for(int time = 0; time < M; time++) {
				Virus[][] next = new Virus[N][N];
				
				Virus virus;
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(board[r][c] == null) continue;
						virus = board[r][c];
						int nr = r + dr[virus.direction];
						int nc = c + dc[virus.direction];
						
						// 이후에 변경 되었을 수도 있기 때문에
						virus.max = virus.total;
						
						// 다음 위치에 이미 군집이 있으면
						if(next[nr][nc] != null) {
							Virus nextVirus = next[nr][nc];
							// 미생물의 수를 합치고
							nextVirus.total += virus.total;
							// 만약 내가 가장 강한 군집이면
							if(virus.total > nextVirus.max) {
								// 내 방향으로 바꾸고 군집의 최대치를 갱신
								nextVirus.direction = virus.direction;
								nextVirus.max = virus.total;
							}
							
						} else {
							// 다음 위치에 군집이 없으면 다음 위치로 이동
							next[nr][nc] = virus;						
						}
					}
				}
				
				// 각 벽면에 붙은 것들을 반대방향으로
				for(int i = 1; i < N-1; i++) {
					if(next[0][i] != null) {
						// 위쪽
						next[0][i].total /= 2;
						next[0][i].direction = 2;
					}
					if(next[N-1][i] != null) {
						// 아래쪽
						next[N-1][i].total /= 2;
						next[N-1][i].direction = 1;
					}
					if(next[i][0] != null) {
						// 왼쪽
						next[i][0].total /= 2;
						next[i][0].direction = 4;
					}
	
					if(next[i][N-1] != null) {
						// 오른쪽
						next[i][N-1].total /= 2;
						next[i][N-1].direction = 3;
					}
				}
				board = next;
			}
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] != null) {
						cnt += board[i][j].total;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
