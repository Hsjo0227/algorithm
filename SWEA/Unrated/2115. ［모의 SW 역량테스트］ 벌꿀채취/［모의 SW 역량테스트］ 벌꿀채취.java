import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] board;
	static int[][] selected;
	static int N, M, C, answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selected = new int[2][M];
			combination(0, 0 ,0);
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	// 작업자의 위치를 고름
	public static void combination(int rStart, int cStart, int cnt) {
		if(cnt == 2) {
			// 대충 벌통 금액 계산하는 코드
			int money1 = collectHoney(0);
			int money2 = collectHoney(1);
			answer = Math.max(answer, money1 + money2);
			return;
		}
		
		for(int c = cStart; c <= N-M; c++) {
			selected[cnt] = Arrays.copyOfRange(board[rStart], c, c+M);
			combination(rStart, c+M, cnt+1);
		}
		for(int r = rStart+1; r < N; r++) {
			for(int c = 0; c <= N-M; c++) {
				selected[cnt] = Arrays.copyOfRange(board[r], c, c+M);
				combination(r, c+M, cnt+1);
			}
		}
	}
	// 작업자의 위치에서 수확할 수 있는 최대 꿀의 가격을 계산
	public static int collectHoney(int idx) {
		int max = 0;
		for(int i = (1<<M)-1; i > 0; i--) {
			int honey = 0;
			int money = 0;
			for(int j = 0; j < M; j++) {
				if((i & (1<<j)) != 0) {
					int num = selected[idx][j];
					honey += num;
					money += num * num;
				}
			}
			if(honey > C) continue;
			max = Math.max(max, money);
		}
		return max;
	}
}
