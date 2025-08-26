import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            int[][] arr = new int[N][2];
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                
            }
            
            Arrays.sort(arr, Comparator.comparingInt(p -> p[0]));
            
            int min = arr[0][1];
            int cnt = 1;
            
            for(int i = 1; i < N; i++) {
                if(min > arr[i][1]) {
                    min = arr[i][1];
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        
        System.out.println(sb);
    }
}