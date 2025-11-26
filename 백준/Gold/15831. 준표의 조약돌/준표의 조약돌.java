import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        String input = br.readLine();
        
        int l = 0;
        int r = 0;
        int black = 0;
        int white = 0;
        int answer = 0;
        
        while(r < N) {
            char ch = input.charAt(r++);
            if(ch == 'B') black++;
            else if(ch == 'W') white++;
            
            while(black > B && l < r) {
                char left = input.charAt(l++);
                if(left == 'B') black--;
                else if(left == 'W') white--;
            }
            
            if(white >= W) answer = Math.max(answer, r - l);
        }
        
        System.out.println(answer);
        
    }
}