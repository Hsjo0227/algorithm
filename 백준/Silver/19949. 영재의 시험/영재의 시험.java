import java.io.*;
import java.util.*;

class Main {
    static int[] input, pick;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        input = new int[10];
        pick = new int[10];
        
        for(int i = 0; i < 10; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0, 0);
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int l, int cnt) {
        if(l >= 3) return;
        
        if(idx == 10) {
            if(cnt >= 5) answer++;
            return;
        }
        
        for(int i = 1; i <= 5; i++) {
            pick[idx] = i;
            
            int nl = 0;
            if(idx >= 1 && pick[idx-1] == i) nl = l+1;
            else nl = 1;
            
            if(pick[idx] == input[idx]) {
                dfs(idx+1, nl, cnt+1);
            } else {
                dfs(idx+1, nl, cnt);
            }
        }
        
    }
}