import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] parents;

	public static void make() {
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			
			make();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0 ; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(operation == 0) {
					union(a, b);
				} else if(operation == 1) {
					int aRoot = findSet(a);
					int bRoot = findSet(b);
					
					if(aRoot == bRoot) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.printf("#%d %s\n", tc, sb);
		}
	}

}
