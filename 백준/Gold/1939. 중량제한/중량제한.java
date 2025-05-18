import java.io.*;
import java.util.*;

public class Main {
    static int N, M, start, end;
    static List<List<int[]>> adj;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int maxWeight = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
            
            maxWeight = Math.max(maxWeight, w);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end   = Integer.parseInt(st.nextToken());

        int l = 1;
        int r = maxWeight;
        int ans = 0;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            if(check(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }
    
    public static boolean check(int limit) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int u = queue.poll();
            if(u == end) return true;
            
            for(int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                
                if(visited[v] || w < limit) continue;
                
                visited[v] = true;
                queue.add(v);
            }
        }
        return false;
    }
}