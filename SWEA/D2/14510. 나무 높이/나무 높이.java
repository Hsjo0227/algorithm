import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				input[i] = num;
			}
			
			int odd = 0;
			int even = 0;
			for(int i = 0; i < N; i++) {
				int sub = max - input[i];
				odd += sub%2;
				even += sub/2;
			}
			
			while(even-1 >= odd+1) {
				
				even--;
				odd += 2;
			}
			System.out.printf("#%d ", tc);
			System.out.println(even>=odd? even*2 : (odd-1)*2+1);
		}
	}
}
