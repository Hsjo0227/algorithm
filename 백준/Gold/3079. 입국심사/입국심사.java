import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        long left = Integer.MAX_VALUE;
        long right = 0;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
//        	right =Math.max(arr[i], right);
        	left = Math.min(arr[i], left);
        }
        right = left*M;
        // end input
        
    	while(left<=right) {
    		long mid = left+(right-left)/2;
//    		System.out.println(left+" "+ mid + " "+ right); 
    		int cnt = 0;
    		for(int i=0; i<N; i++) {	
    			cnt+= mid/arr[i];
    			if(cnt>=M) {
    				break;
    			}
            }
    		
//    		System.out.println(cnt);
    		if(cnt<M) {
    			left = mid+1;
    		}
    		else {
    			right = mid-1;
    		}
//    		System.out.println("=================");
    		
    	}//ene while
        System.out.println(left);
       
    }//end main
}
