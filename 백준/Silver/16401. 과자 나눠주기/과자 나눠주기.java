import java.util.*;
import java.io.*;

public class Main { //백준 2638번 치즈
	static int N,M,arr[];
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[N-1];
        long ans = binarySearch(left, right);
        System.out.println(ans);
    }//end main
    
    static public long binarySearch(long left, long right) {
    	long ans = 0;
    	
    	while(left<=right) {
    		long mid = left+(right-left)/2;
    		int cnt = 0;
    		
    		for(int i=0; i<N; i++) {
    			cnt += arr[i]/mid;
    		}
    		if(cnt>=M) {
    			ans=mid;
    			left = mid+1;
    		}
    		else {
    			right = mid-1;
    		}
    	}
    	return ans;
    }
}
