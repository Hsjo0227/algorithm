import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int g = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] word = new int[52];
		String W = br.readLine();
		for(int i = 0; i < g; i++) {
			char ch = W.charAt(i);
			word[charToIndex(ch)]++;
		}
		
		String sentence = br.readLine();
		int[] window = new int[52];
		int cnt = 0;
		
		for(int i = 0; i < g; i++) {
			char ch = sentence.charAt(i);
			window[charToIndex(ch)]++;
		}
		
		if(Arrays.equals(word, window)) cnt++;
		
		for(int i = 0; i < l-g; i++) {
			char chStart = sentence.charAt(i);
			window[charToIndex(chStart)]--;
			char chEnd = sentence.charAt(i+g);
			window[charToIndex(chEnd)]++;

			if(Arrays.equals(word, window)) cnt++;
		}
		System.out.println(cnt);
		
	}
	
	public static int charToIndex(char ch) {
		if(Character.isUpperCase(ch)) return ch-'A';
		if(Character.isLowerCase(ch)) return ch-'a'+26;
		return -1;
	}

}
