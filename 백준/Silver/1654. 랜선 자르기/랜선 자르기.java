import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken()); //가지고 있는 랜선 개수
		int N = Integer.parseInt(st.nextToken()); //만들어야하는 랜선 개수
		int[] arr = new int[K];
		
		long max = 0;
		long min = 1;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) max = arr[i];
		}
		
		long mid = (min+max)/2;
		long res = max;
		
		while(max-min>=0) {
			long sum = 0;
			
			for(int i=0; i<K; i++) {
				sum += (arr[i]/mid);
				if(sum>N) break;
			}//end for
			
			if(sum>=N) {
				min = mid+1;
				res = mid;
			}
			else {
				max = mid-1;
			}
			mid = (min+max)/2;
		}//end while
		System.out.println(res);
		
	}
}