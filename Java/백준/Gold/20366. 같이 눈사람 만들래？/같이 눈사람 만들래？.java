import java.io.*;
import java.util.*;

class Main {
    static long[] input;
    static long answer;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        input = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        
        answer = Long.MAX_VALUE;
        
        function();
        
        System.out.println(answer);
    }
    
    public static void function() {
        for(int i = 1; i < N - 2; i++) {
            for(int j = i +1; j < N - 1; j++) {
                int left = i - 1;
                int right = j + 1;
                
                long target = input[i] + input[j];
                while(0 <= left && right < N) {
                    long current = input[left] + input[right];
                    answer = Math.min(answer, Math.abs(target - current));
                    
                    if(current == target) {
                        answer = 0;
                        return;
                    } else if(current < target) {
                        right++;
                    } else {
                        left--;
                    }
                }
            }
        }
    }
    
}