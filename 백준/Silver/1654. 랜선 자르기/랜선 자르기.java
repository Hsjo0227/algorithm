import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        long left = 1;
        long right = 0;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	right += arr[i];
        }
        //end input
        long ans = 0;
        while(left<=right) {
        	long mid = left+(right-left)/2;
        	int cnt = 0;
        	
        	for(int i=0; i<N; i++) {
        		cnt += arr[i]/mid;
        	}
        	
        	if(cnt>=M) {
        		left = mid+1;
        		ans = mid;
        	}
        	else right = mid-1;
        }
        System.out.println(ans);
    }//end main
}
