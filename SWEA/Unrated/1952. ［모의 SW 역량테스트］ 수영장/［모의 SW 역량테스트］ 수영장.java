import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] prices = new int[4];
			
			for(int i = 0; i< 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] months = new int[13];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				months[i] = Integer.parseInt(st.nextToken()) * prices[0];
			}
			
			for(int i = 1; i <= 12; i++) {
				// 1일권과 1달권 비교
				months[i] = Math.min(prices[1], months[i]) + months[i-1];
				if(i >= 3) {
                    // 3달권 비교
					months[i] = Math.min(months[i-3] + prices[2], months[i]);
				}
			}
			
			System.out.printf("#%d %d\n",tc ,Math.min(months[12], prices[3]));
		}
	}
}
