import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] prices, months;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			prices = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			months = new int[13];
			int totalDay = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				int num = Integer.parseInt(st.nextToken());
				months[i] = num;
				totalDay += num;
			}
			// 1년 요금제
			answer = prices[3];
			
			calculate(1, 0);
			
			System.out.printf("#%d %d\n", tc, answer);
			
		}
	}
	
	public static void calculate(int start, int sum) {
		if(start > 12) {
			answer = Math.min(answer, sum);
			return;
		}
		
		if(sum >= answer) {
			return;
		}
		
		// 1일 요금제와 1달 요금제를 비교함
		calculate(start+1, sum + Math.min(prices[0] * months[start], prices[1]));
		
		// 3달 요금제
		if(start <= 10) {
			calculate(start+3, sum+prices[2]);
		}


	}
}
