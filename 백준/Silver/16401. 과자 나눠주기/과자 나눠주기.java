import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        input = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        int left = 1;
        int right = 1_000_000_000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            long broken = check(mid);
            
            if(broken >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static long check(int mid) {
        long count = 0;
        for(int i = 0; i < N; i++) {
            count += input[i] / mid;
            
            if(count >= M) break;
        }
        return count;
    }
}