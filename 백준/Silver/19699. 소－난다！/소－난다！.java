import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        boolean[] prime = new boolean[9001];
        Arrays.fill(prime, true);
        for(int i = 2; i <= 9000; i++) {
            if(!prime[i]) continue;
            
            for(int j = i+i; j <= 9000; j += i) {
                prime[j] = false;
            }
        }
        
        Set<Integer> answer = new TreeSet<>();
        
        
        for(int i = 1; i < (1 << N); i++) {
            if(Integer.bitCount(i) != M) continue;
            
            int sum = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0) sum += arr[j];
            }
            
            if(prime[sum]) answer.add(sum);
        }
        
        if(answer.size() == 0) {
            System.out.println(-1);
        }
        
        for(int num : answer) {
            sb.append(num).append(' ');
        }
        
        System.out.println(sb);
    }
}