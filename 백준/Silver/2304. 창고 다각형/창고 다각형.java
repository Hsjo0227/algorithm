import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
				
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		int answer = 0;
		
		int[] prev = arr[0];
		int max = prev[1];
		
		for(int i = 1; i < N; i++) {
			if(arr[i][1] >= prev[1]) {
				answer += (arr[i][0] - prev[0]) * prev[1];
				
				prev = arr[i];
				max = arr[i][1];
			}
		}
		
		prev = arr[N-1];
		
		for(int i = N-2; i >= 0; i--) {
			if(arr[i][1] > prev[1]) {
				answer += (prev[0] - arr[i][0]) * prev[1];
				
				prev = arr[i];
			}
		}
		
		answer += max;
		
		System.out.println(answer);
	}

}
