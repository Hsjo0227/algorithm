import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] input = new int[N+2];
        st = new StringTokenizer(br.readLine());
        input[0] = 0;
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        input[N+1] = L;
        Arrays.sort(input);
        
        int[] list = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = input[i+1] - input[i];
        }
        
        int left = 1;
        int right = L;
        int min = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(check(list, mid) > M) {
                left = mid + 1;
            } else {
                min = mid;
                right = mid - 1;
            }
        }
        System.out.println(min);
        
    }
    
    public static int check(int[] list, int gap) {
        int cnt = 0;
        for(int num : list) {
            cnt += num / gap;
            if(num % gap == 0) cnt--;
        }
        return cnt;
    }
}