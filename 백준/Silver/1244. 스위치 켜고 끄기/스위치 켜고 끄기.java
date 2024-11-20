import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean[] bulbs = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			bulbs[i] = (Integer.parseInt(st.nextToken()) == 1);
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			bulbs[num] = !bulbs[num];
			if(s == 1) {
				for(int j = 2; j * num <= N; j++) {
					bulbs[j*num] = !bulbs[j*num];
				}
			} else {
				for(int j = 1; j < N; j++) {
					if(num-j < 1 || num+j >N) break;
					if(bulbs[num-j] != bulbs[num+j]) break;
					bulbs[num-j] = bulbs[num+j] = !bulbs[num+j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(bulbs[i]? "1" : "0").append(" ");
			if((i) % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}
}
