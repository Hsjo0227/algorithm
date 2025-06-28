import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[][] adj = new long[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                adj[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        boolean[] visited = new boolean[N];
        long[] minEdge = new long[N];
        Arrays.fill(minEdge, Long.MAX_VALUE);
        
        minEdge[0] = 0;
        long result = 0;
        
        for(int i = 0; i < N; i++) {
            int next = -1;
            long min = Long.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                if(!visited[j] && minEdge[j] < min) {
                    min = minEdge[j];
                    next = j;
                }
            }
            
            visited[next] = true;
            result += min;
            
            for(int j = 0; j < N; j++) {
                if(!visited[j] && adj[next][j] < minEdge[j]) {
                    minEdge[j] = adj[next][j];
                }
            }
        }
        
        System.out.println(result);
    }
}