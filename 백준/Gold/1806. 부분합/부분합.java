import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long[] input = new long[N];
        
        for(int i = 0; i < N; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }
        
        long sum = 0;
        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        
        for(right = 0; right < N; right++){
            sum += input[right];
            
            while(sum >= S) {
                answer = Math.min(answer, right - left + 1);
                sum -= input[left++];
            }
            
        }
        
        if(answer == Integer.MAX_VALUE) answer = 0;
        
        System.out.println(answer);
    }
}