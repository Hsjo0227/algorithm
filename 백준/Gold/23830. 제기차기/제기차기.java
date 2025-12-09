import java.io.*;
import java.util.*;

class Main {
    static int N, p, q, r;
    static long S, sum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        
        int left = 1;
        int right = arr[N-1] + 1;
        long answer = Long.MAX_VALUE;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long num = check(mid);
            
            if(num >= S) {
                answer = Math.min(mid, answer);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if(answer == Long.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    
    public static long check(int K) {
        long point = sum;
        int idx = N-1;
        for(; idx >= 0; idx--) {
            if(arr[idx] <= K + r) break;
        }
        
        point -= (long)(N - 1 - idx) * p;
        
        for(idx = 0; idx < N; idx++) {
            if(arr[idx] >= K) break;
        }
        point += (long)q * idx;
        
        return point;
    }
}