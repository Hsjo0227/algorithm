import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        
        for(int i = N - 1; i >= 1; i--) {
            if(arr[i-1] >= arr[i]) {
                answer += arr[i-1] - arr[i] + 1;
                arr[i-1] = arr[i] - 1;
            }
        }
        
        System.out.println(answer);
    }
}