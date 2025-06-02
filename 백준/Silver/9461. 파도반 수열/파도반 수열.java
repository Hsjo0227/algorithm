import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        for(int i = 5; i <= 100; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            sb.append(arr[N]).append("\n");
        }
        System.out.print(sb);
    }
}