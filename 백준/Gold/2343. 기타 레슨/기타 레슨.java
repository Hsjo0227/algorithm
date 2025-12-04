import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int max = 0;
        long sum = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
            sum += num;
        }
        
        long left = max;
        long right = sum;
        long answer = sum;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            int count = 1;
            int temp = 0;
            
            for(int i = 0; i < N; i++) {
                if(temp + arr[i] > mid) {
                    count++;
                    temp = arr[i];
                } else {
                    temp += arr[i];
                }
            }
            
            if(count <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}