import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] inputs = new int[N];
            
            for(int i = 0; i < N; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }
            
            long answer = 0;
            int max = inputs[N-1];
            
            for(int i = N-2; i >= 0; i--) {
                if(inputs[i] < max) {
                    answer += max - inputs[i];
                } else {
                    max = inputs[i];
                }
            }
            
            System.out.println(answer);
            
        }
    }
}