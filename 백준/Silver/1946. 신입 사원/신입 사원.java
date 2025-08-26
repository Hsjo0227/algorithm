import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N+1];
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                arr[idx] = Integer.parseInt(st.nextToken());
            }
            
            int min = arr[1];
            int cnt = 1;
            
            for(int i = 2; i <= N; i++) {
                if(min > arr[i]) {
                    min = arr[i];
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        
        System.out.println(sb);
    }
}