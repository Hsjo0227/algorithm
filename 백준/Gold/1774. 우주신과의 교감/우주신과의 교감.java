import java.io.*;
import java.util.*;

class Main {
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        double cost;
        
        public Edge(int u, int v, double cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Edge e) {
            return Double.compare(this.cost, e.cost);
        }
    }
    
    static int[] parent;
    
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parent[a] = b;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        
        int[][] gods = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            gods[i][0] = Integer.parseInt(st.nextToken());
            gods[i][1] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, 0.0));
        }
        
        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                double dx = gods[i][0] - gods[j][0];
                double dy = gods[i][1] - gods[j][1];
                double l = Math.sqrt(dx * dx + dy * dy);
                edges.add(new Edge(i, j, l));
            }
        }
        
        Collections.sort(edges);
        
        double answer = 0.0;
        for(Edge e : edges) {
            if(union(e.u, e.v)) {
                answer += e.cost;
            }
        }
        
        System.out.printf("%.2f", answer);
    }
}