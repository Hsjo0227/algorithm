import java.io.*;
import java.util.*;

public class Main { //용액
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int A = 0, B = 0;
        long min = Long.MAX_VALUE;

        for(int i=0; i<N; i++) {
            int left = i+1;
            int right = N-1;

            while(left<=right) {
                int mid = (right+left)/2;
                long sum = arr[i]+arr[mid];

                if(min>Math.abs(sum)) {
                    min = Math.abs(sum);
                    A=arr[i];
                    B=arr[mid];
                    if(min==0) break;
                }
                if(sum>0) {
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }//end while
        }
        System.out.println(A+" "+B);
    }//end main
}