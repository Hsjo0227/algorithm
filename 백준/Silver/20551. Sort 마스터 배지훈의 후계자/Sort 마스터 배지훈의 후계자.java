import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			int num = arr[i];
			if(!map.containsKey(num)) {
				map.put(num, i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(br.readLine());
			if(map.containsKey(num)) {
				sb.append(map.get(num)).append("\n");
			}
			else {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
		
	}//end main
}
