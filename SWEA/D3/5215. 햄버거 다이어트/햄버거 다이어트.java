import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][L+1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int point = Integer.parseInt(st.nextToken());
				int calory = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j <= L; j++) {
					if(j >= calory)	dp[i+1][j] = Math.max(dp[i][j-calory] + point, dp[i][j]);
					else dp[i+1][j] = dp[i][j];
				}
			}
			System.out.printf("#%d %d\n", tc, dp[N][L]);
		}
	}

}
