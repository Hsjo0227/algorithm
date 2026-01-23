import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) arr[i][0] = 1;
        for(int i = 0; i < M; i++) arr[0][i] = 1;
        
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                int num = (arr[i][j - 1] + arr[i - 1][j]) % 1_000_000_007;
                num = (num +  + arr[i - 1][j - 1]) % 1_000_000_007;
                arr[i][j] = num;
            }
        }
        
        System.out.println(arr[N - 1][M - 1]);
    }
}