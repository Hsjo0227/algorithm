import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] solution = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solution);
		int left = 0;
		int right = N-1;
		
		int min = Integer.MAX_VALUE;
		int[] answer = {0, N-1};
		
		while(left < right) {
			int sum = solution[left] + solution[right];
			
			if(Math.abs(sum) < Math.abs(min)) {
				min = sum;
				answer[0] = left;
				answer[1] = right;
			}
			
			if(sum == 0) break;
			else if(sum < 0) left++;
			else if(sum > 0) right--;
		}
		System.out.println(solution[answer[0]] + " " + solution[answer[1]]);
	}
}