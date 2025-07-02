import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] solutions = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        
        int l = 0;
        int r = N - 1;
        int answer = Integer.MAX_VALUE;
        
        while(l < r) {
            int sum = solutions[l] + solutions[r];
            
            if(Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }
            
            if(sum < 0) l++;
            else if(sum == 0) break;
            else r--;
        }
        
        System.out.println(answer);
        
    }
}