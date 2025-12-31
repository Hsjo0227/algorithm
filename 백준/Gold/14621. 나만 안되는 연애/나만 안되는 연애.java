 import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr, parent;
    
    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
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
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            char ch = st.nextToken().charAt(0);
            arr[i] = (ch == 'M') ? 1 : 0;
        }
        
        List<int[]> edges = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(arr[u] == arr[v]) continue;
            edges.add(new int[] {u, v, w});
        }
        
        Collections.sort(edges, (arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        parent = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(union(u, v)) answer += w;
        }
        
        for(int i = 2; i <= N; i++) {
            if(find(1) != find(i)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }
}