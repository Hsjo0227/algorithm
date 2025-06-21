import java.io.*;
import java.util.*;

class Main {
    static int[] input;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        input = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        
        long answer = 0;
        
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                int target = -(input[i] + input[j]);
                int left = lowerBound(j + 1, N, target);
                int right = upperBound(j + 1, N, target);
                answer += (right - left);
            }
        }
        
        System.out.println(answer);
        
    }
    static int lowerBound(int l, int r, int target) {
        while(l < r) {
            int mid = (l + r) / 2;
            if(input[mid] < target) l = mid + 1;
            else r = mid;
        }
        
        return l;
    }
    static int upperBound(int l, int r, int target) {
        while(l < r) {
            int mid = (l + r) / 2;
            if(input[mid] <= target) l = mid + 1;
            else r = mid;
        }
        
        return l;
    }
    
}