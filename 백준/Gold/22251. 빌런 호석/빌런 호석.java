import java.io.*;
import java.util.*;

public class Main {
	final static int[] digits = {
			0b1111110,
			0b0110000,
			0b1101101,
			0b1111001,
			0b0110011,
			0b1011011,
			0b1011111,
			0b1110000,
			0b1111111,
			0b1111011
	};
	
	static int[][] diff;
	static int N, K, P;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int f = X;
		
		int[] currentFloor = new int[K];
		
		for(int i = 0; i < K; i++) {
			int digit = f % 10;
			f = f / 10;
			currentFloor[i] = digit;
		}
		
		diff = new int[10][10];
		
		for(int i = 0; i < 10; i++) {
			for(int j = i+1; j < 10; j++) {
				int temp = digits[i] ^ digits[j];
				diff[i][j] = diff[j][i]= Integer.bitCount(temp);
			}
		}
		
		int answer = 0;
		
		for(int floor = 1; floor <= N; floor++) {
			if(floor == X) continue;
			
			int count = 0;
			int to = floor;
			for(int i = 0; i < K; i++) {
				int digit = to % 10;
				
				to = to / 10;
				count += diff[currentFloor[i]][digit];
				if(count > P) break;
			}
			if(count <= P) {
				answer++;
			}
			
		}
		System.out.println(answer);
		
	}
}
