import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        int num = K;
        int cnt = 0;
        
        for(int i = 2; i <= K; i++) {
            while(num % i == 0) {
                num /= i;
                cnt++;
            }
        }
        
        if(cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(32 - Integer.numberOfLeadingZeros(cnt - 1));
        }
    }
}