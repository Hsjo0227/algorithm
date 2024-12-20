import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int M = Integer.parseInt(br.readLine());
        
        boolean[] set = new boolean[21];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;
            switch(op){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set[num] = true;
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set[num] = false;
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append(set[num]? "1" : "0").append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set[num] = !set[num];
                    break;
                case "all":
                    Arrays.fill(set, true);
                    break;
                case "empty":
                    Arrays.fill(set, false);
                    break;
            }
        }
        
        System.out.println(sb);
        
    }
}