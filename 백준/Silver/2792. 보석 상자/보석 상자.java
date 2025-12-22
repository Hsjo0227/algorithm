import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[M];
        int max = 0;
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        int left = 1;
        int right = max;
        int answer = max;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            
            for(int num : arr) {
                cnt += (num + mid - 1) / mid;
            }
            
            if(cnt <= N) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}