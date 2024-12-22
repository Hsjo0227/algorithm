import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if('A' <= ch && ch <= 'Z') ch = (char)(ch + 'a' - 'A');
            else if('a' <= ch && ch <= 'z') ch = (char)(ch + 'A' - 'a');
            sb.append(ch);
        }
        
        System.out.println(sb);
    }
}