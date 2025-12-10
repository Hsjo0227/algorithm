import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[] charArray = br.readLine().toCharArray();
        int[] arr = new int[26];
        for(char ch : charArray) {
            arr[ch-'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            int num = Math.min(arr[i], M);
            M -= num;
            arr[i] = num;
        }
        
        for(char ch : charArray) {
            int idx = ch - 'a';
            
            if(arr[idx] > 0) {
                arr[idx]--; 
                continue;
            } else {
                sb.append(ch);
            }
        }
        
        System.out.println(sb);
    }
}