import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		
		long hash = 0;
		
		String str = br.readLine();
		for(int i = 0; i < L; i++) {
			long ch = str.charAt(i) - 'a' + 1;
			long num = 1;
			for(int j = 0; j < i; j++) {
				num = (num * 31) % 1234567891;
			}
			num = (num * ch) % 1234567891;
			hash = (hash + num) % 1234567891;
		}
		
		System.out.println(hash);
	}
}
