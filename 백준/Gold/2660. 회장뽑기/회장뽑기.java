import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] adj = new int[N+1][N+1];
        
        int[][] d = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE/2);
            d[i][i] = 0;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        while(start != -1 && end != -1) {
            d[start][end] = 1;
            d[end][start] = 1;
            
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        }
        
        
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(i == k) continue;
                for(int j = 1; j <= N; j++) {
                    if(j == i || j == k) continue;
                    if(d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        int[] score = new int[N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                score[i] = Math.max(score[i], d[i][j]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        List<Integer> idx = new ArrayList<>();
        
        for(int i = 1; i <= N; i++) {
            if(score[i] < min) {
                min = score[i];
                idx.clear();
            }
            if(score[i] == min) idx.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(idx.size()).append('\n');
        
        for(int i : idx) {
            sb.append(i).append(' ');
        }
        
        System.out.println(sb);
        
        
    }
}