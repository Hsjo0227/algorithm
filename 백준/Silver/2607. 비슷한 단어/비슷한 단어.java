import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[26];
        
        String base = br.readLine();
        
        for(char ch : base.toCharArray()) {
            arr[ch - 'A']++;
        }
        
        int answer = 0;
        
        for(int i = 0; i < N-1; i++) {
            String str = br.readLine();
            int[] arr2 = new int[26];
            for(char ch : str.toCharArray()) {
                arr2[ch - 'A']++;
            }
            
            int diff = 0;
            for(int j = 0; j < 26; j++) {
                diff += Math.abs(arr[j] - arr2[j]);
            }
            
            int lenDiff = Math.abs(base.length() - str.length());
            
            if(lenDiff == 0 && (diff == 0 || diff == 2)) {
                answer++;
            } else if(lenDiff == 1 && diff == 1) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}