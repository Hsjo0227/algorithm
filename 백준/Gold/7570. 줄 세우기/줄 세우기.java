import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] pos = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            pos[num] = i;
        }
        
        int max = 0;
        int cnt = 0;
        int prev = -1;
        for(int i = 1; i <= N; i++) {
            int cur = pos[i];
            if(cur <= prev) {
                max = Math.max(max, cnt);
                cnt = 1;
            } else {
                cnt++;
            }
            prev = cur;
        }
        
        max = Math.max(max, cnt);
        
        System.out.println(N - max);
    }
}
