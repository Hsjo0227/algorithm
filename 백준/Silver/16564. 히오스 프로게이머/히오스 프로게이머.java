import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int l = 0;
        int r = Integer.MAX_VALUE;
        int answer = 0;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            long sum = calc(mid);
            
            if(sum <= K) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
    
    public static long calc(int level) {
        long sum = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i] >= level) continue;
            sum += (level - arr[i]);
        }
        return sum;
    }
}