import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[N];
		String str = br.readLine();
		String str2 = br.readLine();
		for(int i = 0; i < N; i++) {
			arr[i] = (str.charAt(i) == str2.charAt(i));
		}
		
		int answer = Integer.MAX_VALUE;
		
		// 1번 스위치 안누름
		boolean[] copy = Arrays.copyOf(arr, N);
		int cnt = solve(copy);
		
		if(cnt != -1) answer = Math.min(answer, cnt);
		
		// 1번 스위치 누름
		copy = Arrays.copyOf(arr, N);
		toggle(copy, 0);
		cnt = solve(copy);

		if(cnt != -1) answer = Math.min(answer, cnt+1);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
		
		
	}
	public static int solve(boolean[] arr) {
		int answer = -1;
		
		boolean[] goal = new boolean[N];
		Arrays.fill(goal, true);
		
		int cnt = 0;
		
		for(int i = 1; i < N; i++) {
			if(!arr[i-1]) {
				toggle(arr, i);
				cnt++;
			}
		}
		
		if(Arrays.equals(goal, arr)) {
			answer = cnt;
		}
		return answer;
		
	}
	

	public static void toggle(boolean[] arr, int i) {
		if(i-1 >= 0) arr[i-1] = !arr[i-1];
		arr[i] = !arr[i];
		if(i+1 < N) arr[i+1] = !arr[i+1];
	}
}
