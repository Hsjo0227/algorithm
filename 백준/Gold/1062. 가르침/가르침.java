import java.io.*;
import java.util.*;

class Main {
    static int N, K, answer;
    static int[] characters;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        if(K < 5) {
            System.out.println(0);
            return;
        }
        
        characters = new int[N];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(char ch : str.toCharArray()) {
                characters[i] |= (1 << (ch - 'a'));
            }
        }
        
        int base = 0;
        
        for(char ch : "antic".toCharArray()) {
            base |= (1 << (ch - 'a'));
        }
        
        answer = 0;
        
        dfs(0, 0, base);
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int num, int mask) {
        if(num == K - 5) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                if((characters[i] & mask) == characters[i]) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        if(idx >= 26) return;
        
        for(int i = idx; i < 26; i++) {
            if((mask & (1 << i)) != 0) continue;
            dfs(i + 1, num + 1, mask | (1 << i));
        }
        
    }
}