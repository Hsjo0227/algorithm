import java.io.*;
import java.util.*;

class Main {
    static int N, answer;
    static int[][] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        dist = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                if(i == k) continue;
                for(int j = 0; j < N; j++) {
                    if(j == i) continue;
                    
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        answer = Integer.MAX_VALUE;
        dfs(K, 0, 1 << K);
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int cost, int visited) {
        if(visited == (1 << N) - 1) {
            answer = Math.min(answer, cost);
            return;
        }
        
        if(cost > answer) {
            return;
        }
        
        for(int i = 0; i < N; i++) {
            int mask = 1 << i;
            if((visited & mask) > 0) continue;
            dfs(i, cost + dist[idx][i], visited | mask);
        }
    }
}