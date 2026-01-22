import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = 0;
        int cnt = 0;
        
        for(int i = 0; i < 2 * N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(arr[num]) {
                cnt--;
            } else {
                arr[num] = true;
                cnt++;
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}