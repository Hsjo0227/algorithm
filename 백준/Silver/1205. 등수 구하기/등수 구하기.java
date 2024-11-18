import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N==0) {
			System.out.println(1);
			return;
		}
		
		int[] scoreBoard = new int[P];
		Arrays.fill(scoreBoard, -1);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			scoreBoard[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(scoreBoard);
		
		int answer = 1;
		int i = 1;
		for(; i <= P; i++) {
			int idx = P-i;
			if(scoreBoard[idx] > newScore) answer = i+1;
			if(scoreBoard[idx] < newScore) break;
		}
		if(i > P) answer = -1;
		System.out.println(answer);
	}
}
