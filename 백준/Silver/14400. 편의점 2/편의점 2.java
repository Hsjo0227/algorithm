import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] x = new int[N];
        int[] y = new int[N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(x);
        Arrays.sort(y);
        
        long answer = 0;
        
        for(int i = 0; i < N; i++) {
            answer += Math.abs(x[i] - x[N/2]);
            answer += Math.abs(y[i] - y[N/2]);
        }
        
        System.out.println(answer);
    }
}