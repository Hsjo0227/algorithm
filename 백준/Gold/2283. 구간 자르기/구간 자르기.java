import java.io.*;
import java.util.*;

class Main {
    static int[][] sections;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        sections = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sections[i][0] = Integer.parseInt(st.nextToken());
            sections[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 1;
        int[] answer = new int[2];
        
        while(left < 1_000_000 && right <= 1_000_000) {
            long result = calc(left, right);
            if(result == K) {
                answer = new int[] {left, right};
                break;
            } else if(result < K) {
                right++;
            } else {
                left++;
            }
        }
        
        System.out.println(answer[0] + " " + answer[1]);
        
    }
    
    public static long calc(int start, int end) {
        long sum = 0;
        for(int i = 0; i < N; i++) {
            int[] section = sections[i];
            int startMax = Math.max(start, section[0]);
            int endMin = Math.min(end, section[1]);
            
            sum = sum + (long)Math.max(0, endMin - startMax);
        }
        
        return sum;
    }
}