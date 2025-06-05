import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];

        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);

        int max = 0;
        for(int i = N-1; i >= 0; i--) {
            int weight = input[i] * (N - i);
            if(max < weight) {
                max = weight;
            }
        }

        System.out.println(max);
    }
}