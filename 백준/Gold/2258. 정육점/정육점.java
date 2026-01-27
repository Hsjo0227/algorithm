import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        
        long[][] arr = new long[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long w = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            arr[i] = new long[] {w, c};
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] != b[1]) return Long.compare(a[1], b[1]);
            return -Long.compare(a[0], b[0]);
        });
        
        long sum = 0;
        long answer = Long.MAX_VALUE;
        
        long prev = -1;
        long cnt = 0;
        
        for(int i = 0; i < N; i++) {
            long w = arr[i][0];
            long c = arr[i][1];
            
            sum += w;
            
            if(c == prev) cnt++;
            else {
                prev = c;
                cnt = 1;
            }
            
            if(sum >= M) {
                answer = Math.min(answer, c * cnt);
            }
        }
        
        if(answer == Long.MAX_VALUE) {
            answer = -1L;
        }
        
        System.out.println(answer);
    }
}