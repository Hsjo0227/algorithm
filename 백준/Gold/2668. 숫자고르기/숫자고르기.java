import java.io.*;
import java.util.*;

public class Main {
    
    int N;
    int[] inputs;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        
        boolean[] visited = new boolean[N+1];
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            int count = 1;
            boolean[] newVisited = Arrays.copyOf(visited, N+1);
            
            int start = i;
            int cur = inputs[start];
            
            while(true) {
                if(newVisited[cur]) break;
                newVisited[cur] = true;
                if(cur == start) {
                    answer += count;
                    visited = newVisited;
                    break;
                }
                cur = inputs[cur];
                count++;
            }
            
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        
        for(int i = 1; i <= N; i++) {
        	if(visited[i]) {
            	sb.append(i).append("\n");
        	}
        }
        System.out.println(sb);
    }
}