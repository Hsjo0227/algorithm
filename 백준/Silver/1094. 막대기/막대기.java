import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for(int i = 64; i >= 1; i /= 2) {
            if(X / i != 0) {
                answer += X / i;
                X %= i;
            }
        }
        System.out.println(answer);
    } 
}