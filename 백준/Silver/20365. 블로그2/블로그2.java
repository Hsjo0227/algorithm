import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        char[] arr = br.readLine().toCharArray();
        
        int red = 0;
        int blue = 0;
        
        char prev = arr[0];
        
        if(prev == 'B') blue++;
        else red++;
        
        for(int i = 1; i < N; i++) {
            if(arr[i] == prev) continue;
            
            if(arr[i] == 'B') blue++;
            else red++;
            prev = arr[i];
        }
        System.out.println(1 + Math.min(red, blue));
    }
}