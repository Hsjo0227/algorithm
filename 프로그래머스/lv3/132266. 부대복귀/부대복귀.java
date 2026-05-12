import java.util.*;

class Solution {
    
    static class Node {
        public int no;
        public Node next;
        
        public Node(int no, Node next) {
            this.no = no;
            this.next = next;
        }
    }
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        
        Node[] adj = new Node[n+1];
        for(int i = 0; i < roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            
            adj[start] = new Node(end, adj[start]);
            adj[end] = new Node(start, adj[end]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(destination);
        visited[destination] = true;
        
        int count = 0;
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
            
                int cur = queue.poll();
                
                for(int i = 0; i < sources.length; i++) {
                    if(cur == sources[i]) answer[i] = depth;
                }
                
                for(Node node = adj[cur]; node != null; node = node.next) {
                    if(visited[node.no]) continue;
                    visited[node.no] = true;
                    queue.offer(node.no);
                }
            }
            depth++;
        }
        
        return answer;
    }
}