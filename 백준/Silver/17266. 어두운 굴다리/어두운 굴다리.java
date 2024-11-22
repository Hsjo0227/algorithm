import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int prev = Integer.parseInt(st.nextToken());
        int answer = prev;
        int current = 0;
        for(int i = 0; i < M-1; i++) {
            current = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, (current-prev+1)/2);
            prev = current;
        }
        answer = Math.max(answer, N-prev);
        
        System.out.println(answer);
        
    }
}