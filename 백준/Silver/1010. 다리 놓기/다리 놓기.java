import java.io.*;
import java.util.*;

public class Main {
//	static int N, M;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[31][31];
		
		for(int i = 0; i < 31; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			N = Math.min(N, M-N);
			System.out.println(function(M, N));
		}
	
	}
	private static int function(int n, int r) {
		if(dp[n][r]!=0) {
			return dp[n][r];
		}
		return dp[n][r] = function(n-1,r-1) + function(n-1, r);
	}
}
