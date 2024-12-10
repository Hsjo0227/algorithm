import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String str = input + input;
		
		int l = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == 'a') l++;
		}
		
		int cnt = 0;
		
		for(int i = 0; i < l; i++) {
			if(input.charAt(i) == 'b') cnt++;
		}
		int min = cnt;
		
		for(int i = 0; i < input.length(); i++) {
			if(str.charAt(i) == 'b') cnt--;
			if(str.charAt(i+l) == 'b') cnt++;
			min = Integer.min(min, cnt);
		}
		System.out.println(min);
	}
}
