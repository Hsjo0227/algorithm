import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][3];
        for(int i = 0; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0, 0, 0);
        System.out.println(answer);
        
    } 
    
    public static void dfs(int idx, int num, int r, int g, int b) {
        if(num >= 2) {
            answer = Math.min(answer, calc(num, r, g, b));
        }
        
        if(idx == N || num == 7) {
            return;
        }
        
        dfs(idx + 1, num + 1, r + arr[idx][0], g + arr[idx][1], b + arr[idx][2]);
        
        dfs(idx + 1, num, r, g, b);
    } 
    
    public static int calc(int num, int r, int g, int b) {
        return Math.abs(r / num - arr[N][0])
            + Math.abs(g / num - arr[N][1])
            + Math.abs(b / num - arr[N][2]);
    }
}