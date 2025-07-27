import java.io.*;
import java.util.*;

class Main {
    static int[][] people;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            answer = 0;
            people = new int[11][11];
            
            for(int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++) {
                    people[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dfs(0, 0, 0);
            System.out.println(answer);
        }
    }
    
    public static void dfs(int idx, int score, int used) {
        if(idx == 11) {
            answer = Math.max(answer, score);
            return;
        }
        
        for(int i = 0; i < 11; i++) {
            if((used & (1 << i)) != 0) continue;
            if(people[i][idx] == 0) continue;
            
            dfs(idx+1, score + people[i][idx], used | (1 << i));
        }
    }
}