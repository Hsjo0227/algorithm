import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < N; tc++) {
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            
            Set<String> set = new TreeSet<>();
            
            do {
                set.add(new String(arr));
            } while(np(arr));
            
            for(String str : set) {
                sb.append(str).append('\n');
            }
        }
        
        System.out.println(sb);
    }
    
    public static boolean np(char[] arr) {
        int n = arr.length;
        int i = n - 1;
        
        while(i > 0 && arr[i-1] >= arr[i]) i--;
        
        if(i == 0) return false;
        
        int j = n-1;
        
        while(arr[i-1] >= arr[j]) j--;
        
        swap(arr, i-1, j);
        
        j = n - 1;
        
        while(i < j) swap(arr, i++, j--);
        
        return true;
    }
    
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}