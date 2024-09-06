import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		// 세번째는 파이프의 방향(가로, 세로, 대각선)
		long[][][] dp = new long[N][N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][1][0] = 1;
		for(int i = 2; i < N; i++) {
			if(board[0][i] != 1) dp[0][i][0] = dp[0][i-1][0];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(board[i][j] == 1) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				if(board[i-1][j] == 1 || board[i][j-1] == 1) continue;
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		long sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += dp[N-1][N-1][i];
		}
		
		System.out.println(sum);
	}

}
