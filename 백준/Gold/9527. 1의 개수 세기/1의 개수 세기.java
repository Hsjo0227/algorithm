import java.io.*;
import java.util.*;


public class Main {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		dp = new long[55];
		
		dp[0] = 1;
		
		for(int i = 1; i < 55; i++) {
			dp[i] = (dp[i-1] << 1) + (1L << i);
		}
		
		long result = countOne(B) - countOne(A-1);
		System.out.println(result);

	}
	
	public static long countOne(long num) {
		long count = num & 1;
		int size = (int) (Math.log(num) / Math.log(2));
		
		for(int i = size; i > 0; i--) {
			if((num & (1L << i)) != 0L) {
				count += dp[i-1] + (num - (1L << i) + 1);
				num -= (1L << i);
			}
		}
		
		return count;
	}
}
