import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] cows = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cows);
        
        int answer = 0;
        for(int i = N-1; i > N/2; i--) {
            answer += cows[i] * 2;
        }
        
        if(N % 2 == 1) {
            answer += cows[N/2];
        } else {
            answer += cows[N/2] * 2;
        }
        
        System.out.println(answer);
        
    }
}