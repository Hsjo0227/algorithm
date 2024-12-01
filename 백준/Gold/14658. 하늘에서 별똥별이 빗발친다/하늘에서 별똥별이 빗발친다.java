import java.io.*;
import java.util.*;

public class Main {
    static int L, K;
    static int[][] meteors;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        meteors = new int[K][2];
        
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            meteors[i] = new int[]{x, y};
        }
        
        int answer = 0;
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < K; j++) {
                int x = meteors[i][0];
                int y = meteors[j][1];
                
                answer = Math.max(answer, countMeteor(x, y));
                
            }
        }
        
        System.out.println(K-answer);
        
    }
    
    public static int countMeteor(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < K; i++) {
            if(x <= meteors[i][0] && meteors[i][0] <= x+L 
            && y <= meteors[i][1] && meteors[i][1] <= y+L) cnt++;
        }
        
        return cnt;
    }
}