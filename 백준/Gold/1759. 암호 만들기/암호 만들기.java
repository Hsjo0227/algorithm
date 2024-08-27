import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[] characters = new char[C];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++) {
			characters[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(characters);
		
		int[] arr = new int[C];
		
		for(int i = C-1; i >= L; i--) {
			arr[i] = 1;
		}
		
		StringBuilder sb;
		do {
			sb = new StringBuilder();
			int aeiou = 0;
			int others = 0;
			
			for(int i = 0; i < C; i++) {
				if(arr[i] == 0) {
					char ch = characters[i];
					if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') aeiou++;
					else others++;
					sb.append(ch);
				}
			}
			
			if(aeiou >= 1 && others >= 2) System.out.println(sb);
			
		}while(np(arr));
		
		
		
	}

	public static boolean np(int[] arr) {
		int i = C-1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = C-1;
		while(arr[i-1] >= arr[j]) j--;
		
		swap(i-1, j, arr);
		
		int k = C-1;
		while(i < k) {
			swap(i++, k--, arr);
		}
		
		return true;
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
