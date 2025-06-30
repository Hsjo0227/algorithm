import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] parent;
    public static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return false;
        
        parent[a] = b;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        int[] truth = new int[T];
        for(int i = 0; i < T; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }
        
        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        int[] party = new int[M];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            party[i] = prev;
            
            for(int j = 0; j < num - 1; j++) {
                int cur = Integer.parseInt(st.nextToken());
                union(prev, cur);
                prev = cur;
            }
        }
        
        boolean[] visited = new boolean[N+1];
        for(int i = 0; i < T; i++) {
            int idx = find(truth[i]);
            visited[idx] = true;
        }
        
        
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            int idx = find(party[i]);
            if(!visited[idx]) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}