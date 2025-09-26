import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int answer = 0;
        int l = 0;
        int left = arr[0][1];
        int sum = 0;
        
        for(int r = 0; r < N; r++) {
            int right = arr[r][1];
            sum += arr[r][0];
            
            while(left + 2 * K < right) {
                sum -= arr[l][0];
                l++;
                left = arr[l][1];
            }
            answer = Math.max(answer, sum);
        }
        
        
        System.out.println(answer);
        
    }
}