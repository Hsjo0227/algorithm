import java.io.*;
import java.util.*;

class Main {
    static int N, K, cnt;
    static int[] kits;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        
        kits = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 500);
        
        System.out.println(cnt);
    }
    
    public static void dfs(int visited, int power) {
        if(Integer.bitCount(visited) == N) {
            cnt++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(((1 << i) & visited) != 0) continue;
            int nextPower = power - K + kits[i];
            if(nextPower < 500) continue;
            dfs((visited | (1 << i)), nextPower);
        }
    }
}