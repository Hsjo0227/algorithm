import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;
            
            if(A > B) {
                int temp = A;
                A = B;
                B = temp;
            }
            
            int C = 2 * A - B;
            if(C <= A) {
                System.out.println(C);
                continue;
            }
            
            C = 2 * B - A;
            if(C >= B) {
                System.out.println(C);
                continue;
            }
            
            C = (A + B)/2;
            System.out.println(C);
            
        }
    }
}