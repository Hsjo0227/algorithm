import java.io.*;
import java.util.*;

class Main {
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[K+1];
        Arrays.fill(arr, INF);
        arr[0] = 0;
        
        for(int i = 1; i <= N; i++) {
            int coin = Integer.parseInt(br.readLine());
            for(int j = coin; j <= K; j++) {
                arr[j] = Math.min(arr[j], arr[j-coin]+1);
            }
        }
        
        int answer = (arr[K] == INF) ? -1 : arr[K];
        System.out.println(answer);
    }
}