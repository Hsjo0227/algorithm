import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] adj = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE/2);
            adj[i][i] = 0;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj[u][v] = adj[v][u] = 1;
        }
        
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(i == k) continue;
                for(int j = 1; j <= N; j++) {
                    if(i == j || j == k) continue;
                    
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        
        int[] answer = {1, 2, Integer.MAX_VALUE};
        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                int sum = 0;
                for(int k = 1; k <= N; k++) {
                    sum += Math.min(adj[i][k], adj[j][k]);
                }
                sum = sum * 2;
                
                if(sum < answer[2]) {
                    answer[0] = i;
                    answer[1] = j;
                    answer[2] = sum;
                }
            }
        }
        
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}