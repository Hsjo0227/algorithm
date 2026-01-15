import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long[] arr = new long[N];
        long max = 0;
        
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        long left = 1;
        long right = max * M;
        long answer = right;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long cnt = 0;
            for(int i = 0; i < N; i++) {
                cnt += mid / arr[i];
                if(cnt >= M) break;
            }
            
            if(cnt >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}