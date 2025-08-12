import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[N+1];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            arr[i] = str;
            map.put(str, i);
        }
        
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                int num = Integer.parseInt(str);
                sb.append(arr[num]).append('\n');
            } else {
                sb.append(map.get(str)).append('\n');
            }
        }
        System.out.println(sb);
    }
}