import java.util.*;

class Solution {
    static int[] parent;
    
    public static void make(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    
    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    public static int union(int a, int b, int cost) {
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA == parentB) return 0;
        
        parent[parentA] = parentB;
        return cost;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        for (int[] way : costs) {
            pq.offer(way);
        }
        
        make(n);
        
        while(!pq.isEmpty()) {
            int[] way = pq.poll();
            int start = way[0];
            int end = way[1];
            int cost = way[2];
            
            answer += union(start, end, cost);
        }
        
        return answer;
    }
    
    
}