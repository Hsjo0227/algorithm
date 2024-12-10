import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][N];
		
		dp[0][0] = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i][0] = dp[i-1][0] + Integer.parseInt(st.nextToken());
			for(int j = 1; j <= i-1; j++) {
				dp[i][j] = Integer.max(dp[i-1][j-1], dp[i-1][j]) + Integer.parseInt(st.nextToken());
			}
			dp[i][i] = dp[i-1][i-1] + Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Integer.max(max, dp[N-1][i]);
		}
		
		System.out.println(max);
	}
}
