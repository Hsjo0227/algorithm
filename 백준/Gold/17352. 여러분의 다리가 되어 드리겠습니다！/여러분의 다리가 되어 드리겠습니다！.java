import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    static int N;
    
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
        
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        
        for(int i = 0; i <= N; i++) parent[i] = i;
        
        for(int i = 0; i < N-2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            union(a, b);
        }
        
        int a = find(1);
        int b = 0;
        for(int i = 2; i <= N; i++) {
            int num = find(i);
            if(a != num) {
                b = num;
            }
        }
        System.out.println(a + " " + b);
    }
}