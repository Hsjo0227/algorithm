import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int count;
	static int[] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N];
		count = 0;
		dfs(0);
		
		System.out.println(count);
		
	}
	
	public static void dfs(int idx) {
		if(idx == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(check(idx, i)) {
				board[idx] = i;
				dfs(idx+1);
			}
		}
	}
	
	public static boolean check(int pos, int num) {
		for(int i = 0; i < pos; i++) {
			if(board[i] == num) return false;
			if(Math.abs(i-pos) == Math.abs(board[i]-num)) return false;
		}
		return true;
	}
}
