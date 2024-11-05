import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();

        int left = 0;
        int right = 0;
        long answer = 0;
        while(right < N) {
            if(set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
                continue;
            }
            answer += right - left + 1;
            set.add(arr[right++]);
        }
        
        System.out.println(answer);
    }
}
