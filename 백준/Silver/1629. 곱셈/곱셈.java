import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		
		System.out.println(function(A, B, C));
	}
	
	public static long function(long A, long B,long C) {
		if(B == 1) {
			return A % C;
		}
		long temp = function(A, B/2, C);
		
		if(B%2==0) {
			return (temp * temp) % C;
		} else {
			return ((temp * temp) % C * A % C) % C;
		}
	}
}
