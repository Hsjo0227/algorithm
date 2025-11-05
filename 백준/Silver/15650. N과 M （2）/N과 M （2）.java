import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        dfs(0, 1);
        
        System.out.println(sb);
    }
    
    public static void dfs(int depth, int start) {
        if(depth == M) {
            for(int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}