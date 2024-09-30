import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][K+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int volume = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j <= K; j++) {
					if(j >= volume) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-volume]+value);
					else dp[i][j] = dp[i-1][j];
				}
			}
			
			System.out.printf("#%d %d\n", tc, dp[N][K]);
		}
	}

}
