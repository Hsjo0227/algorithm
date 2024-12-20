import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        System.out.println(solve(str));
        
    }
    
    public static int solve(String str) {
        StringBuilder sb = new StringBuilder(str);
        
        int i = 1;
        
        for(i = 1; i <= Integer.MAX_VALUE; i++) {
            String num = String.valueOf(i);
            for(int j = 0; j < num.length(); j++) {
                if(sb.charAt(0) == num.charAt(j)) sb.delete(0, 1);
                if(sb.length() == 0) return i;
            }
        }
        
        return i;
    }
}