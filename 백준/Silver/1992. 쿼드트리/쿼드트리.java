import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] board;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i< N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		
		sb = new StringBuilder();
		
		divide(0,0,N);
		System.out.println(sb);
	}
	
	public static void divide(int r, int c, int size) {
		int sum = 0;
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				sum += board[i][j];
			}
		}
		
		if(sum == 0) {
			sb.append("0");
		} else if(sum == size * size) {
			sb.append("1");
		} else {
			sb.append("(");
			int half = size/2;
			divide(r, c, half);
			divide(r, c+half, half);
			divide(r+half, c, half);
			divide(r+half, c+half, half);
			sb.append(")");
		}
	}
}
