import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        long sum = 0;
        for(int i = 0; i < K; i++) sum += arr[i];
        
        long max = sum;
        for(int i = K; i < N; i++) {
            sum -= arr[i-K];
            sum += arr[i];
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
    }
}