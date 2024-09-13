import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	String[] arr = new String[N];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	if(N>32) {
        		sb.append(0+"\n");
        		continue;
        	}
        	for(int j=0; j<N; j++) {
        		arr[j] = st.nextToken();
        	}
        	int min = Integer.MAX_VALUE;
        	loop:
        	for(int k=0; k<N; k++) {
        		for(int l=k+1; l<N; l++) {
        			for(int m=l+1; m<N; m++) {
        				int cnt = 0;
        				for(int o=0; o<4; o++) {
        					cnt += arr[k].charAt(o) != arr[l].charAt(o)? 1 : 0;
        					cnt += arr[k].charAt(o) != arr[m].charAt(o)? 1 : 0;
        					cnt += arr[l].charAt(o) != arr[m].charAt(o)? 1 : 0;
        				}
        				min = Math.min(min, cnt);
        				if(min==0) break loop;
        			}
        		}
        	}
        	sb.append(min+"\n");
        }//end T
        System.out.println(sb);
    }//end main
}