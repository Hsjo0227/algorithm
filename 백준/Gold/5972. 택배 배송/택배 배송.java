import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int no;
        int weight;
        Node next;
        
        public Node(int no, int weight, Node next){
            this.no = no;
            this.weight = weight;
            this.next = next;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;
        
        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Node[] adj = new Node[N+1];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            adj[start] = new Node(end, weight, adj[start]);
            adj[end] = new Node(start, weight, adj[end]);
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 1, 0));
        
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        dist[1] = 0;
        visited[1] = true;
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            visited[edge.end] = true;
            
            // 도착하면 끝
            if(edge.end == N) {
                break;
            }
            // 추가된 노드에서 인접 노드까지의 간선 추가 
            for(Node nextNode = adj[edge.end]; nextNode != null; nextNode = nextNode.next) {
                int newDist = dist[edge.end] + nextNode.weight;
                if(!visited[nextNode.no] && newDist < dist[nextNode.no]){
                    dist[nextNode.no] = newDist;
                    pq.offer(new Edge(edge.end, nextNode.no, dist[nextNode.no]));
                }
            }
        }
        
        System.out.println(dist[N]);
        
    }
}