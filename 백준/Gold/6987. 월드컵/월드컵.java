import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int[][] input;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		for(int tc = 0; tc < 4; tc++) {
			input = new int[6][3];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int[][] result = new int[6][3];
			
			answer = 0;
			dfs(0, 1, result);
			
			sb.append(answer).append(" ");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int a, int b, int[][] arr) {
		if(a == 5) {
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					if(arr[i][j] != input[i][j]) return;
				}
			}
			answer = 1;
			return;
		}
		
		int[][] copy = new int[6][3];
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		
		int nextB = b+1;
		int nextA = a;
		if(nextB >= 6) {
			nextA++;
			nextB = nextA+1;
		}
		
		// a가 b를 이김
		copy[a][0]++;
		copy[b][2]++;
		if(copy[a][0] <= input[a][0] && copy[b][2] <= input[b][2]) {
			// 입력으로 들어온 결과보다 승, 패수가 많다면 넘어감
			dfs(nextA, nextB, copy);
		}
		// 원상 복구
		copy[a][0]--;
		copy[b][2]--;
		
		// a가 b와 비김
		copy[a][1]++;
		copy[b][1]++;
		if(copy[a][1] <= input[a][1] && copy[b][1] <= input[b][1]) {
			// 입력으로 들어온 결과보다 승, 패수가 많다면 넘어감
			dfs(nextA, nextB, copy);
		}
		// 원상 복구
		copy[a][1]--;
		copy[b][1]--;
				
		// a가 b에게 짐
		copy[a][2]++;
		copy[b][0]++;
		if(copy[a][2] <= input[a][2] && copy[b][0] <= input[b][0]) {
			// 입력으로 들어온 결과보다 승, 패수가 많다면 넘어감
			dfs(nextA, nextB, copy);
		}
	}
}
