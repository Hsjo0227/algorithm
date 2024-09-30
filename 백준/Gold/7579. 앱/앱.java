import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		
		int temp = 10001;
		int[][] dp = new int[N+1][temp];
		
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			
			for(int j = 0; j <= 10000; j++) {
				if(c > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c]+m);
			}
		}
		
		int cost = 0;
		for(; cost <= 10000; cost++) {
			if(dp[N][cost] >= M) break;
		}
		
		
		System.out.println(cost);
	}
}
