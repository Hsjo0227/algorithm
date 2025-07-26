import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    //static List<List<int[]>> adj;
    static List<int[]> adj;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken())+1;
        
        adj = new ArrayList<>();
        
        // for(int i = 0; i <= N; i++) {
        //    adj.add(new ArrayList<>());
        // }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            // adj.get(u).add(new int[] {v, 1-w});
            // adj.get(v).add(new int[] {u, w});
            
            adj.add(new int[] {u, v, 1-w});
            // adj.add(new int[] {v, u, w});
        }
        adj.sort((arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        
        parent = new int[N+1];
        Arrays.fill(parent, -1);
        
        int min = 0;
        for(int i = 0; i < M; i++) {
            int[] edge = adj.get(i);
            if(union(edge[0], edge[1])) {
                min += edge[2];
            }
        }
        
        Arrays.fill(parent, -1);
        
        int max = 0;
        for(int i = M-1; i >= 0; i--) {
            int[] edge = adj.get(i);
            if(union(edge[0], edge[1])) {
                max += edge[2];
            }
        }
                
        System.out.println(max * max - min * min);
        
        
        
    }
    
    public static int find(int a) {
        if(parent[a] == -1) return a;
        return parent[a] = find(parent[a]);
    }
    
    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return false;
        parent[a] = b;
        return true;
    }
}