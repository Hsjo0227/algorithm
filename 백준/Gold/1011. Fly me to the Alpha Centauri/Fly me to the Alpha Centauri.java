import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = end - start;
			
			int jump = 0;
			int d = 1;
			
			while(distance > 0) {
				distance -= d;
				jump++;
				if(jump %2 == 0) d++;
			}
			
			sb.append(jump).append("\n");
			
		}
		System.out.println(sb);
	}
}
