import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println("NO");
            return;
        }

        String str = Integer.toString(N, 3);

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '2') {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}