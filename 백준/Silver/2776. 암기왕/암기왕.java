import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }
            
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(set.contains(num)? "1\n": "0\n");
            }
            String str = sb.toString().trim();
            System.out.println(str);
        }
    }
}