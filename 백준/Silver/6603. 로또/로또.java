import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(st.nextToken());
        
        while(K != 0) {
            int[] arr = new int[K];
            for(int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] mask = new int[K];
            for(int i = 6; i < K; i++) mask[i] = 1;
            
            do {
                int cnt = 0;
                for(int i = 0; i < K; i++) {
                    if(mask[i] == 0) {
                        if(cnt > 0) sb.append(' ');
                        sb.append(arr[i]);
                        cnt++;
                    }
                }
                sb.append('\n');
            } while(np(mask));
            
            sb.append('\n');
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
    
    public static boolean np(int[] arr) {
        int N = arr.length;
        int idx = N-1;
        while(idx > 0 && arr[idx - 1] >= arr[idx]) idx--;
        
        if(idx == 0) return false;
        
        int target = N-1;
        while(arr[idx-1] >= arr[target]) target--;
        
        swap(arr, idx-1, target);
        
        int left = idx;
        int right = N-1;
        
        while(left < right) {
            swap(arr, left++, right--);
        }
        return true;
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}