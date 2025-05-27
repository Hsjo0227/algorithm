import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder answer = new StringBuilder();
            
            // String A = String.format("%80s",st.nextToken()).replace(" ", "0");
            // String B = String.format("%80s",st.nextToken()).replace(" ", "0");
            StringBuilder A = new StringBuilder(st.nextToken()).reverse();
            StringBuilder B = new StringBuilder(st.nextToken()).reverse();
            int l = Math.max(A.length(), B.length());
            
            int carry = 0;
            for(int i = 0; i < l; i++) {
                int a = 0;
                int b = 0;
                if(i < A.length()) a = A.charAt(i)-'0';
                if(i < B.length()) b = B.charAt(i)-'0';
                
                int result = a + b + carry;
                carry = result / 2;
                result = result % 2;
                answer.append(result);
            }
            
            if(carry == 1) answer.append("1");
            l = answer.length();
            int idx = l - answer.lastIndexOf("1") - 1;
            String str = answer.reverse().substring(idx, l);
            
            if(str.length() == 0) str = "0";
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}