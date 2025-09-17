import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int tc = 1;
        
        
        while(a != 0 || b != 0) {
            int cnt = 0;
            
            int num = 0;
            int i = 1;
            
            while(true) {
                num += i++;
                
                if(num+1 >= b) break;
                if(num+1 <= a) continue;
                
                double sqrt = Math.sqrt(num+1);
                
                if(sqrt != Math.floor(sqrt)) continue;
                cnt++;
            }
            
            
            
            
            
            sb.append("Case ")
                .append(tc++)
                .append(": ")
                .append(cnt)
                .append('\n');
            
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
        }
        System.out.println(sb);
    }
}