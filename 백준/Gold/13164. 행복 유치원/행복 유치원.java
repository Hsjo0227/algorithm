import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N - 1];
        for(int i = 0; i < N - 1; i++) {
            arr[i] = input[i + 1] - input[i];
        }

        Arrays.sort(arr);

        long result = 0;
        int groups = N - K;
        for (int i = 0; i < groups; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}