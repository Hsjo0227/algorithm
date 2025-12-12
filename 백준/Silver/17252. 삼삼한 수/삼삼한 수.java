import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N == 0) {
            System.out.println("NO");
            return;
        } 
        
        long num = 1;
        
        while(num * 3 <= N) {
            num *= 3;
        }
        
        for(; num >= 1; num = num / 3) {
            if(num <= N) {
                N -= num;
            }
        }
        
        System.out.println(N == 0 ? "YES" : "NO");
    }
}