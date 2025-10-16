import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(B);
            
            long answer = 0;
            for(int i = 0; i < N; i++) {
                int idx = Arrays.binarySearch(B, A[i]);
                
                if(idx >= 0) {
                    answer += B[idx];
                } else {
                    idx = -idx - 1;
                    
                    if(idx == 0) {
                        answer += B[0];
                    } else if(idx == M) {
                        answer += B[M - 1];
                    } else if(Math.abs(A[i] - B[idx-1]) <= Math.abs(A[i] - B[idx])) {
                        answer += B[idx - 1];
                    } else {
                        answer += B[idx];
                    }
                }
                
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}