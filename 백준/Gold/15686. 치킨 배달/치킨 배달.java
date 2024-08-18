import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> stores = new ArrayList<>();
	static int[][] chosen;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chosen = new int[M][2];
		
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					houses.add(new int[] {i, j});
				}
				if(num == 2) {
					stores.add(new int[] {i, j});
				}
			}
		}
		
		int answer = combination(0, 0);
		
		System.out.println(answer);
		
		
	}
	
	public static int combination(int cnt, int start) {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0; i < houses.size(); i++) {
				int distance = Integer.MAX_VALUE;
				for(int j = 0; j < cnt; j++) {
					int dr = Math.abs(houses.get(i)[0] - chosen[j][0]);
					int dc = Math.abs(houses.get(i)[1] - chosen[j][1]);
					distance = Math.min(distance, dr + dc);
				}
				sum += distance;
			}
			return sum;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = start; i < stores.size(); i++) {
			chosen[cnt] = stores.get(i);
			min = Math.min(min, combination(cnt+1, i +1));
		}
		return min;
	}

}
