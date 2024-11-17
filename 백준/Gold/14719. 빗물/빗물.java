import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] blocks = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < W; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		
		for(int i = 1; i <= H; i++) {
			int before = W;
			for(int j = 0; j < W; j++) {
				if(blocks[j] >= i) {
					if(j > before+1) {
						answer += j-before-1;
					}
					before = j;
				}
			}
		}
		
		
		System.out.println(answer);
	}
}
