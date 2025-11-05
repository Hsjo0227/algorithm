import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        
        dfs(0);
        
        System.out.println(sb);
    }
    
    public static void dfs(int depth) {
        if(depth == M) {
            for(int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth+1);
            visited[i] = false;
        }
    }
}