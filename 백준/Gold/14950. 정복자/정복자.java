import java.io.*;
import java.util.*;

class Main {
    
    static int[] parent;
    static int N, M, t;
    
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        List<int[]> roads = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            roads.add(new int[] {u, v, w});
        }
        
        Collections.sort(roads, Comparator.comparingInt(arr -> arr[2]));
        
        parent = new int[N+1];
        Arrays.fill(parent, -1);
        
        int answer = 0;
        
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            
            if(union(u, v)) answer += w;
        }
        
        answer += t * (N - 1) * (N - 2) / 2;
        
        System.out.println(answer);
        
    }
}