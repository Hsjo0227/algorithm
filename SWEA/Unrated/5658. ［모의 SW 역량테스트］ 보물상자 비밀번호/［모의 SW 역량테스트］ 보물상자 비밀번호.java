import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String str = br.readLine();
			
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < N/4; i++) {
				for(int j = 0; j < 3; j++) {
					String s = str.substring(j* N/4+i, (j+1)* N/4+i);
					if(!list.contains(s)) list.add(s);
				}
				String s = str.substring(3* N/4+i) + str.substring(0, i);
				if(!list.contains(s)) list.add(s);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			String s = list.get(K-1);
			
			System.out.printf("#%d %d\n", tc, Integer.valueOf(s, 16));
		}
	}
}
