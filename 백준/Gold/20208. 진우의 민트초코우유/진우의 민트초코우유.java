import java.io.*;
import java.util.*;

class Main {
    static int N, M, H, answer, milkCnt;
    static List<int[]> milk;
    static int[] start;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][N];
        milk = new ArrayList<>();
        milkCnt = 0;
        start = new int[2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num == 1) {
                    start = new int[] {i, j};
                } else if(num == 2) {
                    milk.add(new int[] {i, j});
                    milkCnt++;
                }
            }
        }
        answer = 0;
        
        if(milkCnt != 0) dfs(start[0], start[1], 0, M, 0); 
        
        
        System.out.println(answer);
        
    }
    
    public static void dfs(int r, int c, int cnt, int health, int visited) {
        int distance = Math.abs(r - start[0]) + Math.abs(c - start[1]);
        if(distance <= health) {
            answer = Math.max(answer, cnt);
        }
        
        for(int i = 0; i < milk.size(); i++) {
            if(((1 << i) & visited) != 0) continue;
            int[] arr = milk.get(i);
            
            distance = Math.abs(r - arr[0]) + Math.abs(c - arr[1]);
            
            if(distance <= health) {
                dfs(arr[0], arr[1], cnt+1, health - distance + H, (1 << i) | visited);
            }
        }
    }
}