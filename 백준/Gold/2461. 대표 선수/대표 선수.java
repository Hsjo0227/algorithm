import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] student = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(student[i]);
        }
        
        int[] idx = new int[N];
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            max = Math.max(max, student[i][0]);
            min = Math.min(min, student[i][0]);
        }
        
        int answer = max - min;
        
        
        while(true) {
            int minClass = -1;
            int minValue = Integer.MAX_VALUE;
            
            for(int i = 0; i < N; i++) {
                if(minValue > student[i][idx[i]]) {
                    minValue = student[i][idx[i]];
                    minClass = i;
                }
            }
            
            idx[minClass]++;
            
            if (idx[minClass] == M) break;
            
            int newValue = student[minClass][idx[minClass]];
            max = Math.max(max, newValue);
            
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                minValue = Math.min(minValue, student[i][idx[i]]);
            }
            answer = Math.min(answer, max - minValue);
        }
        
        System.out.println(answer);
    }
}