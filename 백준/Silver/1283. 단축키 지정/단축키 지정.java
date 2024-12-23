import java.io.*;
import java.util.*;

public class Main {
    static String[] words;
    static boolean[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        words = new String[N];
        chars = new boolean[27];
        
        
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        for(int i = 0; i < N; i++) {
            keyBind(i, words[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(words[i]).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void keyBind(int idx, String str) {
        String word = str.toLowerCase();
        StringTokenizer st = new StringTokenizer(word);
        int pointer = 0;
        
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            char ch = token.charAt(0);
            if(!chars[ch-'a']) {
            	markKey(idx, pointer);
                return;
            }
            pointer += token.length() + 1;
        }
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == ' ') continue;
            if(!chars[ch-'a']) {
                markKey(idx, i);
                return;
            }
        }
    }
    
    // 단축키를 표시하는 메서드
    public static void markKey(int idx, int loc) {
        String str = words[idx];
        char ch = str.toLowerCase().charAt(loc);
        chars[ch - 'a'] = true;
        words[idx] = str.substring(0, loc) + "[" + str.charAt(loc) + "]" + str.substring(loc+1);
    }
}