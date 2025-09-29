import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        long[] arr2 = new long[N+1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= N; i++) {
            arr2[i] = arr2[i-1] + arr[i];
        }
        
        long answer = 0;
        for(int i = 2; i <= N-1; i++) {
            long sum = arr2[N] - arr2[1];
            sum += arr2[N] - arr2[i];
            sum -= arr[i];
            
            answer = Math.max(answer, sum);
            
            sum = arr2[i] - arr2[1];
            sum += arr2[N-1] - arr2[i-1];
            answer = Math.max(answer, sum);
            
            sum = arr2[N-1];
            sum += arr2[i-1];
            sum -= arr[i];
            
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}