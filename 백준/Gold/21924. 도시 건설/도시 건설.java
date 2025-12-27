import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] parent;
    
    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA == parentB) return false;
        
        parent[parentA] = parentB;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parent = new int[N+1];
        
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int[][] arr = new int[M][3];
        
        long total = 0;
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {u, v, w};
            total += w;
        }
        Arrays.sort(arr, (int[] a, int[] b) -> Integer.compare(a[2], b[2]));
        
        for(int i = 0; i < M; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            int w = arr[i][2];
            if(union(u, v)) total -= w;
        }
        
        int p = find(1);
        for(int i = 2; i <= N; i++) {
            if(p == find(i)) continue;
            System.out.println(-1);
            return;
        }
        
        System.out.println(total);
    }
}