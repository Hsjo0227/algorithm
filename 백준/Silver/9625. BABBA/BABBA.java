import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        int a = 1;
        int b = 0;
        
        for(int i = 0; i < K; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        
        System.out.println(a + " " + b);
    }
}