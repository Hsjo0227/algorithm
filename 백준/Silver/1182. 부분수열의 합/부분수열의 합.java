import java.io.*;
import java.util.*;

class Main {
    static int answer, N, S;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        answer = 0;
        dfs(0, 0);
        
        if(S == 0) answer--;
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int sum) {
        if(idx == N) {
            if(sum == S) answer++;
            return;
        }
        
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}