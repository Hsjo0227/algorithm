import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        System.out.println(solve(str));
        
    }
    
    public static int solve(String str) {
        int i = 1;
        
        int end = str.length();
        int start = 0;
        for(i = 1; i <= Integer.MAX_VALUE; i++) {
            String num = String.valueOf(i);
            for(int j = 0; j < num.length(); j++) {
                if(str.charAt(start) == num.charAt(j)) start++;
                if(start == end) return i;
            }
        }
        
        return i;
    }
}