import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int left = 1;
        int right = 2;
        
        while(right <= (G+1)/2) {
            int g = right * right - left * left;
            
            if(g == G) {
                sb.append(right).append('\n');
                right++;
            } else if(g < G) {
                right++;
            } else {
                left++;
            }
        }
        
        if(sb.length() == 0) sb.append(-1);
        System.out.print(sb);
    }
}