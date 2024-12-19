import java.io.*;
import java.util.*;

public class Main {
	
	//zero, one, two, three, four, five, six, seven, eight, nine, 자리수 없음
	static String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N-M+1];
		for(int i = M; i <= N; i++) {
			arr[i-M] = i;
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = convert(o1);
				String str2 = convert(o2);
				return str1.compareTo(str2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= N-M; i++) {
			sb.append(arr[i]).append(" ");
			if((i+1)%10 == 0) sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static String convert(int num) {
		StringBuilder sb = new StringBuilder();
		for(char digit : String.valueOf(num).toCharArray()) {
			sb.append(words[digit-'0']).append(" ");
		}
		return sb.toString();
	}

}
