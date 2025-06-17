import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[2][10];
        
        for(int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 10; j++) {
                int sum = 0;
                
                for(int k = 0; k <= j; k++) {
                    sum = (sum + arr[(i-1) % 2][k]) % 10007;
                }
                
                arr[i % 2][j] = sum;
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < 10; i++) {
            answer = (answer + arr[(N-1) % 2][i]) % 10007;
        }
        
        System.out.println(answer);
        
        
    }
}