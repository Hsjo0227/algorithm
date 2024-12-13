import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] input = new long[N];
        for(int i = 0; i < N; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(input);
        
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        
        for(int i = 0; i < N; i++) {
            long first = input[i];
            int left = 0;
            int right = N-1;
            
            while(left < right) {
                if(left == i) left++;
                if(right == i) right--;
                if(left >= right) break;
                
                long sum = first + input[left] + input[right];
                if(sum == 0) {
                    answer[0] = first;
                    answer[1] = input[left];
                    answer[2] = input[right];
                    break;
                }
                if(Math.abs(sum) < Math.abs(min)){
                    min = sum;
                    answer[0] = first;
                    answer[1] = input[left];
                    answer[2] = input[right];
                }
                
                if(sum < 0) left++;
                if(sum > 0) right--;
            }
        }
        
        Arrays.sort(answer);
        
        System.out.println(answer[0] + " " + answer[1] + " " +answer[2]);
    }
    
}