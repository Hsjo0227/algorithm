import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int count = 0;
        
        for(int i = 0; i < N; i++) {
            int targetNumber = arr[i];
            int left = 0;
            int right = N-1;
            
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }
                if(sum == targetNumber) {
                    count++;
                    break;
                }
                
                if(sum > targetNumber) {
                    right--;
                } else if(sum < targetNumber) {
                    left++;
                }
            }
        }
        
        
        System.out.println(count);
    }
}