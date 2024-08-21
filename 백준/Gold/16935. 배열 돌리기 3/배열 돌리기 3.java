import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < R; i++ ) {
			int op = Integer.parseInt(st.nextToken());
			switch(op) {
			case 1:
				operation1();
				break;
			case 2:
				operation2();
				break;
			case 3:
				operation3();
				break;
			case 4:
				operation4();
				break;
			case 5:
				operation5();
				break;
			case 6:
				operation6();
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void operation1() {
		int n = board.length;
		for(int i = 0; i < n/2; i++) {
			int[] temp = board[i];
			board[i] = board[n-1-i];
			board[n-1-i] = temp;
		}
	}
	
	public static void operation2() {
		int n = board.length;
		int m = board[0].length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				int temp = board[i][j];
				board[i][j] = board[i][m-1-j];
				board[i][m-1-j] = temp;
			}
		}
	}
	
	public static void operation3() {
		int n = board.length;
		int m = board[0].length;
		int[][] nBoard = new int[m][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				nBoard[j][n-1-i] = board[i][j];
			}
		}
		board = nBoard;
	}
	
	public static void operation4() {
		int n = board.length;
		int m = board[0].length;
		int[][] nBoard = new int[m][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				nBoard[m-1-j][i] = board[i][j];
			}
		}
		board = nBoard;
	}
	
	public static void operation5() {
		int n = board.length;
		int m = board[0].length;
		int[][] nBoard = new int[n][m];
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < m/2; j++) {
				nBoard[i][j+m/2] = board[i][j];
			}
		}
		for(int i = 0; i < n/2; i++) {
			for(int j = m/2; j < m; j++) {
				nBoard[i+n/2][j] = board[i][j];
			}
		}
		for(int i = n/2; i < n; i++) {
			for(int j = m/2; j < m; j++) {
				nBoard[i][j-m/2] = board[i][j];
			}
		}
		for(int i = n/2; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				nBoard[i-n/2][j] = board[i][j];
			}
		}
		
		board = nBoard;
		
	}
	public static void operation6() {
		int n = board.length;
		int m = board[0].length;
		int[][] nBoard = new int[n][m];
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < m/2; j++) {
				nBoard[i+n/2][j] = board[i][j];
			}
		}
		for(int i = 0; i < n/2; i++) {
			for(int j = m/2; j < m; j++) {
				nBoard[i][j-m/2] = board[i][j];
			}
		}
		for(int i = n/2; i < n; i++) {
			for(int j = m/2; j < m; j++) {
				nBoard[i-n/2][j] = board[i][j];
			}
		}
		for(int i = n/2; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				nBoard[i][j+m/2] = board[i][j];
			}
		}
		
		board = nBoard;
	}
}
