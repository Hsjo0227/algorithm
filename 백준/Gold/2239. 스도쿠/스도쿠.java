import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] board;
	static int[][] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		answer = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			String str = br.readLine();
			for(int j = 0; j < 9; j++) {
				int num = str.charAt(j) - '0';
				board[i][j] = num;
			}
		}
		
		dfs(0);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	public static boolean dfs(int num) {
		if(num == 81) {
			return true;
		}
		int r = num/9;
		int c = num%9;
		
		if(board[r][c] != 0) {
			return dfs(num+1);
		} else {
			for(int i = 1; i <= 9; i++) {
				if(check(r, c, i)) {
					board[r][c] = i;
					if(dfs(num+1) == true) return true;
					board[r][c] = 0;
				}
			}
		}
		
		return false;
	}
	
	
	public static boolean check(int r, int c, int num) {
		for(int i = 0; i < 9; i++) {
			if(board[r][i] == num) return false;
			if(board[i][c] == num) return false;
		}
		
		for(int i = r/3*3; i < (r/3+1)*3; i++) {
			for(int j = c/3*3; j < (c/3+1)*3; j++) {
				if(board[i][j] == num) return false;
			}
		}
		
		return true;
	}
}
