import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[] item = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dist = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE/2;
            }
        }
        
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[start][end] = weight;
            dist[end][start] = weight;
        }
        
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] <= M) {
                    sum += item[j];
                }
            }
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
}