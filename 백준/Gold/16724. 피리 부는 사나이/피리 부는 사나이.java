import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parent = new int[N * M];
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                
                int now = i * M + j;
                int next = -1;
                switch(ch) {
                    case 'D':
                        next = now + M;
                        break;
                    case 'U':
                        next = now - M;
                        break;
                    case 'L':
                        next = now - 1;
                        break;
                    case 'R':
                        next = now + 1;
                        break;
                }
                
                if(next < 0 || next >= N * M ) break;
                union(now, next);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < N * M; i++) {
            if(parent[i] == -1) answer++;
        }
        
        System.out.println(answer);
        
    }
    
    public static int find(int a) {
        if(parent[a] == -1) return a;
        return parent[a] = find(parent[a]);
    }
    
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        
        parent[a] = b;
    }
}
