import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] person = new int[N][2];
        int[] answer = new int[N];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            person[i][0] = height;
            person[i][1] = weight;
            
            
            for(int j = 0; j < i; j++) {
                if(person[j][0] > height && person[j][1] > weight) answer[i]++;
                else if(person[j][0] < height && person[j][1] < weight) answer[j]++;
            }
            
        }
        
        for(int i = 0; i < N; i++) {
            sb.append((answer[i]+1)).append(" ");
        }
        
        System.out.println(sb);
        
        
    }
}