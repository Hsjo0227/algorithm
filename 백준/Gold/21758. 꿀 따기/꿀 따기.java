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
        for(int i = 1; i <= N-2; i++) {
            for(int j = i+1; j <= N-1; j++) {
                if(i == j) continue;
                for(int k = j+1; k <= N; k++){
                    if(i == k || j == k) continue;
                    
                    long sum = arr2[k] - arr2[i];
                    sum += arr2[k] - arr2[j];
                    sum -= arr[j];
                    answer = Math.max(answer, sum);
                    
                    sum = arr2[j] - arr2[i];
                    sum += arr2[k-1] - arr2[j-1];
                    answer = Math.max(answer, sum);
                    
                    sum = arr2[j-1] - arr2[i-1];
                    sum += arr2[k-1] - arr2[i-1];
                    sum -= arr[j];
                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }
}