import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;
        
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }
    
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) return false;
        parent[parentB] = parentA;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        
        List<Edge> edges = new ArrayList<>();
        
        for(int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, cost));
        }
        
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i < j) edges.add(new Edge(i, j, cost));
            }
        }
        
        Collections.sort(edges);
        long answer = 0;
        for(Edge edge : edges) {
            if(union(edge.start, edge.end)) answer += edge.weight;
        }
        System.out.println(answer);
        
    }
}