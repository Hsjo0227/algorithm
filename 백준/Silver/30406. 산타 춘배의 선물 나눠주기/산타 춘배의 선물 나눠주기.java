import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
        }
        
        int answer = 0;
        int num = Math.min(arr[0], arr[3]);
        arr[0] -= num;
        arr[3] -= num;
        answer += 3 * num;
        
        num = Math.min(arr[1], arr[2]);
        arr[1] -= num;
        arr[2] -= num;
        answer += 3 * num;
        
        for(int i = 0; i < 4; i++) {
            if(arr[i] == 0) continue;
            
            int j = 3;
            for(; j >= 0; j--) {
                if(arr[j] != 0) break;
            }
            num = Math.min(arr[i], arr[j]);
            answer += num * (i ^ j);
        }
        
        System.out.println(answer);
    }
}