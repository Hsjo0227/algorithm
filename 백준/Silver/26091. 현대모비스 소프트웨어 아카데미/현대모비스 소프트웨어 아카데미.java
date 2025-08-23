import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] input = new int[N];
        
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        
        int left = 0;
        int right = N-1;
        int answer = 0;
        
        while(left < right) {
            int sum = input[left] + input[right];
            
            if(sum >= M) {
                left++;
                right--;
                answer++;
            } else {
                left++;
            }
        }
        
        System.out.println(answer);
        
    }
}