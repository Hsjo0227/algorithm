import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		long lo = 1;
		long hi = arr[arr.length-1] - arr[0]+1;
		long mid = 0;
		
		while(lo<hi) {
			mid = (lo+hi)/2;
			long lastHouse = arr[0];
			int count = 1;
			
			for(int i=0; i<N; i++) {
				if(arr[i]-lastHouse>=mid) {
					count++;
					lastHouse = arr[i];
				}
				
			}//end for
			if(count<C) {
				hi = mid;
			}
			else {
				lo = mid+1;
			}
			
		}//end while
		
		System.out.println(lo-1);
	}//end main
}