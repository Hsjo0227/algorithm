import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[] sleep = new boolean[N+3];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            sleep[num] = true;
        }
        
        st = new StringTokenizer(br.readLine());
        boolean[] attended = new boolean[N+3];
        for(int i = 0; i < Q; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(sleep[num]) continue;
            
            for(int j = num; j <= N+2; j += num) {
                if(sleep[j]) continue;
                if(attended[j]) continue;
                attended[j] = true;
            }
        }
        
        int[] sum = new int[N+3];
        for(int i = 1; i <= N+2; i++) {
            if(!attended[i]) {
                sum[i] = sum[i-1] + 1; 
            } else {
                sum[i] = sum[i-1];
            }
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int answer = sum[end] - sum[start - 1];
            sb.append(answer).append('\n');
        }
        
        System.out.println(sb);
    }
}