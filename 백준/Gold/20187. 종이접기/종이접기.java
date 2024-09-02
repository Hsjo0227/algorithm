import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] holeNum = {0, 1, 2, 3};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		// 종이에 뚫려있는 구멍의 위치
		int[][] answer = new int[1<<k][1<<k];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 반전되지 않은 구역
		int rStart = 0;
		int cStart = 0;
		int rEnd = (1<<k);
		int cEnd = (1<<k);
		
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			switch(str) {
			case "D": {
				rStart = ((rStart+rEnd)/2);
				break;
			}
			case "U": {
				rEnd = ((rStart+rEnd)/2);
				break;
			}
			case "R": {
				cStart = ((cStart+cEnd)/2);
				break;
			}
			case "L": {
				cEnd = ((cStart+cEnd)/2);
				break;
			}
			}
		}
		
		int hole = Integer.parseInt(br.readLine());
		// 가로, 세로 반전된 구멍 숫자
		int garo = 0;
		int sero = 0;
		int cross = 0;
		
		if(hole == 0) {
			garo = 1;
			sero = 2;
			cross = 3;
		} else if(hole == 1) {
			garo = 0;
			sero = 3;
			cross = 2;
		} else if(hole == 2) {
			garo = 3;
			sero = 0;
			cross = 1;
		} else if(hole == 3) {
			garo = 2;
			sero = 1;
			cross = 0;
		}
		
		answer[rStart][cStart] = hole;
		// 끝까지 다 접고 구멍내면 옆칸끼리 좌우, 상하 반전
		for(int i = 0; i < 1<<k; i++) {
			for(int j = 0; j < 1<<k; j++) {
				int r = (rStart+i) % (1<<k);
				int c = (cStart+j) % (1<<k);
				int dr = Math.abs(rStart - r);
				int dc = Math.abs(cStart - c);
				if(dr%2 == 0 && dc%2 == 0) {
					answer[r][c] = hole;
				} else if(dr%2 == 1 && dc%2 == 0) {
					answer[r][c] = sero;
				} else if(dr%2 == 0 && dc%2 == 1) {
					answer[r][c] = garo;
				} else if(dr%2 == 1 && dc%2 == 1) {
					answer[r][c] = cross;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 1<<k; i++) {
			for(int j = 0; j < 1<<k; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
}
