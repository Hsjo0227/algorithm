import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		answer = 0;
		divide(0, 0, 1<<N);
	}
	
	public static void divide(int r, int c, int size) {
		if(r == R && c == C) {
			System.out.println(answer);
			return;
		}
		
		int half = size/2;
		
		if(R < r+half && C < c+half) {
			// 왼쪽 위
			divide(r, c, half);
		} else if(R < r+half && C >= c+half) {
			// 오른쪽 위
			answer += half*half;
			divide(r, c+half, half);
		} else if(R >= r+half && C < c+half) {
			// 왼쪽 아래
			answer += half*half * 2;
			divide(r+half, c, half);
		} else {
			// 오른쪽 아래
			answer += half*half * 3;
			divide(r+half, c+half, half);
		}
	}
	
}
