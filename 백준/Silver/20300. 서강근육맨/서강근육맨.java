import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] input = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(input);
        
        long answer = 0;
        
        if(N % 2 == 0) {
            for(int i = 0; i < N/2; i++) {
                answer = Math.max(answer, input[i] + input[N-1-i]);
            }
        } else {
            for(int i = 0; i < N/2; i++) {
                answer = Math.max(answer, input[i] + input[N-2-i]);
            }
            answer = Math.max(answer, input[N-1]);
        }
        
        System.out.println(answer);
    }
}