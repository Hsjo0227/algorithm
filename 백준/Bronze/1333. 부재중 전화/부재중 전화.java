import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int answer = D;
			
			for(int i = D; i < (L+5) * N; i += D) {
				int time = i % (L+5);
				if(L <= time && time < L+5) {
					answer = i;
					break;
				}
				answer = i + D;
			}
			System.out.println(answer);
		}
	}
