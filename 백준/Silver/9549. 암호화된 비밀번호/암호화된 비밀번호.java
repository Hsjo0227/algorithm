import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            String encrypted = br.readLine();
            String password = br.readLine();
            
            int N = encrypted.length();
            int M = password.length();
            
            int[] cntPassword = new int[26];
            int[] window = new int[26];
            
            for(int i = 0; i < M; i++) {
                cntPassword[password.charAt(i) - 'a']++;
            }
            
            for(int i = 0; i < M; i++) {
                window[encrypted.charAt(i) - 'a']++;
            }
            
            int diff = 0;
            for(int i = 0; i < 26; i++) {
                if(window[i] != cntPassword[i]) diff++;
            }
            
            boolean match = (diff == 0);
            
            for(int i = M; i < N; i++) {
                if(match) break;
                
                int l = encrypted.charAt(i - M) - 'a';
                if(window[l] == cntPassword[l]) diff++;
                window[l]--;
                if(window[l] == cntPassword[l]) diff--;
                
                int r = encrypted.charAt(i) - 'a';
                if(window[r] == cntPassword[r]) diff++;
                window[r]++;
                if(window[r] == cntPassword[r]) diff--;
                
                if(diff == 0) match = true;
            }
            
            sb.append(match ? "YES\n" : "NO\n");
        }
        
        System.out.println(sb);
    }
}