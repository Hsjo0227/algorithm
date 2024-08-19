import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] result = new int[N][10];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] p = {2,3,4,5,6,7,8,9};
		int max = 0;
		
		do {
			int idx = 0;
			int inning = 0;
			int tasoo = -1;
			int out = 0;
			int[] taseok = new int[8];
			
			while(inning < N) {
				if(out >=3 ) {
					out = 0;
					for(int i = 3; i >= 1; i--) {
						taseok[i] = 0;
					}
					inning++;
					continue;
				}
				if(idx < 3) {
					tasoo = result[inning][p[idx]];
				} else if(idx == 3) {
					tasoo = result[inning][1];
				} else {
					tasoo = result[inning][p[idx-1]];
				}
				
				if(tasoo == 0) {
					out++;
				} else {
					for(int i = 3; i >= 1; i--) {
						taseok[i+tasoo] += taseok[i];
						taseok[i] = 0;
					}
					taseok[tasoo] += 1;
					
				}
				idx = (idx+1)%9;
			}
			
			int point = 0;
			for(int i = 4; i < 8; i++) {
				point += taseok[i];
			}
			
			max = Math.max(max, point);
		} while(np(p));
		
		System.out.println(max);
	}
	
	public static boolean np(int[] p) {
		int i = 7;
		while(i > 0 && p[i-1] >= p[i]) --i;
		if(i == 0) return false;
		int j = 7;
		while(p[i-1] >= p[j]) --j;
		swap(p, i-1, j);
		
		int k = 7;
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