import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int max = 0;
        for(int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int point = 0;
            for(int j = 0; j < 4; j++) {
                point += Integer.parseInt(st.nextToken());
            }
            
            if(point > max) {
                num = i;
                max = point;
            }
            
        }
        System.out.println(num + " " + max);
    }
}