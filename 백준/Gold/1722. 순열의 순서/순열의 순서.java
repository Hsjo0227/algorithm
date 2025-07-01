import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int type = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        long factorial = 1;
        
        for(int i = N; i > 0; i--) {
            factorial *= i;
        }
        
        if(type == 1) {
            long input = Long.parseLong(st.nextToken());
            
            input--;
            
            
            StringBuilder sb = new StringBuilder();
            
            for(int i = N; i > 0; i--) {
                factorial /= i;
                
                int div = (int)(input / factorial);
                input = input % factorial;
                
                sb.append(list.get(div)).append(' ');
                list.remove(div);
            }
            
            System.out.println(sb);
            
        } else if(type == 2) {
            long answer = 1;
            
            for(int i = N; i > 0; i--) {
                factorial /= i;
                int input = Integer.parseInt(st.nextToken());
                
                int idx = list.indexOf(input);
                list.remove(idx);
                answer += (long)idx * factorial;
            }
            
            System.out.println(answer);
        }
        
    }
}