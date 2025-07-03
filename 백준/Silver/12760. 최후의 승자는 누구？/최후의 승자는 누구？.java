import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] card = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(card[i]);
        }
        
        int[] score = new int[N];
        int scoreMax = 0;
        
        for(int i = M - 1; i >= 0; i--) {
            int max = 0;
            for(int j = 0; j < N; j++) {
                max = Math.max(max, card[j][i]);
            }
            
            for(int j = 0; j < N; j++) {
                if(card[j][i] == max) score[j]++;
                scoreMax = Math.max(scoreMax, score[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            if(score[i] == scoreMax) sb.append(i+1).append(' ');
        }
        
        System.out.println(sb);
    }
}