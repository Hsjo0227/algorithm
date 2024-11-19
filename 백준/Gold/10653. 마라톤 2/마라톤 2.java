import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] point = new int[N][2];
		int[][] dp = new int[N][K+1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point[i][0] = x;
			point[i][1] = y;
			
			for(int j = 0; j <= K; j++) {
				if(i > 0) dp[i][j] = dp[i-1][j] + (Math.abs(point[i-1][0] - x) + Math.abs(point[i-1][1] - y));
				
				// 몇개의 체크포인트를 건너뛸 지
				for(int k = 1; k <= j; k++) {
					int prev = i-1-k;
					if(prev < 0) continue;
					dp[i][j] = Math.min(dp[i][j], dp[prev][j-k] + (Math.abs(point[prev][0] - x) + Math.abs(point[prev][1] - y)));
					
				}

			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 0; i <= K; i++) {
			answer = Math.min(answer, dp[N-1][i]);
		}
		System.out.println(answer);
	}

}
