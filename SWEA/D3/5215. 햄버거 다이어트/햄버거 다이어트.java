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
			int L = Integer.parseInt(st.nextToken());
			
			int[][] ingredient = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for(int i = 1; i <= N; i++) {
				int[] set = new int[N];
				for(int j = N-i; j < N; j++) {
					set[j] = 1;
				}
				
				do {
					int calory = 0;
					int point = 0;
					for(int j = 0; j < N; j++) {
						if(set[j] == 1) {
							point += ingredient[j][0];
							calory += ingredient[j][1];
						}
						if(calory > L) break;
					}
					if(calory > L) continue;
					answer = Math.max(answer, point);
				} while(np(set));
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	
	public static boolean np(int[] p) {
		int N = p.length;
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) --i;
		if(i == 0) return false;
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		swap(p, i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
