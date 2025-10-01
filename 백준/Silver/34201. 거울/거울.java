import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long answer = 0;
        if(N%2 == 0) {
            long positive = 0;
            for(int i = N/2; i < N; i++) {
                positive += arr[i];
            }
            
            long negative = 0;
            for(int i = 0; i < N/2; i++) {
                negative += arr[i];
            }
            
            answer = s + 2 * (positive - negative);
            
        } else {
            long positive = 0;
            for(int i = N/2; i < N; i++) {
                positive += arr[i];
            }
            
            long negative = 0;
            for(int i = 0; i < N/2; i++) {
                negative += arr[i];
            }
            
            answer = -s + 2L * (positive - negative);
        }
        
        System.out.println(answer);
    }
}