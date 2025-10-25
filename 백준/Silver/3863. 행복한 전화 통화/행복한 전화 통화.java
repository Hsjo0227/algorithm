import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        while(N != 0 && M != 0) {
            int[][] calls = new int[N][2];
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                st.nextToken();
                
                int start = Integer.parseInt(st.nextToken());
                int end = start + Integer.parseInt(st.nextToken());
                calls[i] = new int[] {start, end};
            }
            
            for(int i = 0; i < M; i++) {
                int cnt = 0;
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = l + Integer.parseInt(st.nextToken());
                
                for(int[] call : calls) {
                    if(call[1] <= l || r <= call[0]) continue;
                    cnt++;
                }
                sb.append(cnt).append('\n');
            }
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(sb);
    }
}