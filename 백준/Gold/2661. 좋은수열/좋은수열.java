import java.io.*;
import java.util.*;

class Main {
    static int N;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        dfs(0, sb);
        System.out.println(answer);
    }
    
    public static boolean dfs(int length, StringBuilder sb) {
        int l = sb.length();
        
        
        for(int i = 1; i <= l / 2; i++) {
            String str1 = sb.substring(l - 2 * i, l - i);
            String str2 = sb.substring(l-i, l);
            
            if(str1.equals(str2)) {
                return false;
            }
        }
        
        if(l == N) {
            answer = sb.toString();
            return true;
        }
        
        for(int i = 1; i <= 3; i++) {
            sb.append(i);
            boolean findAnswer = dfs(length+1, sb);
            if(findAnswer) return true;
            sb.deleteCharAt(sb.length()-1);
        }
        
        return false;
    }
}