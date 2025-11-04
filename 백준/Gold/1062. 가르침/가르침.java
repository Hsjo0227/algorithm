import java.io.*;
import java.util.*;

class Main {
    static int N, K, answer;
    static int[] words;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        words = new int[N];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(char ch : str.toCharArray()) {
                int bit = 1 << (ch - 'a');
                words[i] |= bit;
            }
        }
        
        if(K < 5) {
            System.out.println(0);
            return;
        }
        
        int base = 0;
        for(char ch : "antic".toCharArray()) {
            int bit = 1 << (ch - 'a');
            base |= bit;
        }
        
        dfs(base, 5, 1);
        System.out.println(answer);
    }
    
    public static void dfs(int teach, int num, int idx) {
        if(num == K) {
            int cnt = 0;
            for(int word : words) {
                if((word & teach) == word) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        if(idx >= 26) return;
        
        for(int i = idx; i < 26; i++) {
            if((teach & (1 << i)) != 0) continue;
            dfs(teach | (1 << i), num + 1, i + 1);
        }
    }
}