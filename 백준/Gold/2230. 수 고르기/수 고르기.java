import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] input = new int[N];
        
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(input);
        
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        
        
        while(left < N && right < N) {
            int diff = input[right] - input[left];
            
            if(diff >= M) {
                if(answer > diff) {
                    answer = diff;
                }
                left++;
            } else {
                right++;
            }
            
            if(left == right) {
                right++;
            }
        }
        System.out.println(answer);
    }
}