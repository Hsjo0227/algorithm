import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        long left = 0;
        long right = 0;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	left = Math.max(arr[i], left);
        	right+=arr[i];
        }
        //end input
        long ans = 0;
        int cnt = 0;
        
        while(left<=right) {
        	long mid = left+(right-left)/2;
        	cnt = 1;
        	long money = mid;
        	for(int i=0; i<N; i++) {
        		if(money-arr[i]<0) {
        			cnt++;
        			money = mid-arr[i];
        		}
        		else {
        			money -= arr[i];
        		}
        	}
//        	System.out.println(left+" "+mid+" "+right+" "+cnt);
        	if(cnt<=M) {
        		right=mid-1;
        		ans = mid;
        	}
        	else if(cnt>M){
        		left = mid+1;
        	}
        }//end while
        if(cnt==M) System.out.println(left);
        else System.out.println(ans);
        
    }//end main
}
