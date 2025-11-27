import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        arr = new int[N];
        int total = 0;
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        
        int l = 0;
        int r = total;
        int answer = 0;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(check(mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
    
    public static boolean check(int x) {
        int cnt = 0;
        
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            if(sum >= x) {
                cnt++;
                sum = 0;
            }
        }
        
        return cnt >= K;
    }
}