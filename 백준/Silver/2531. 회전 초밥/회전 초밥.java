import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] sushi = new int[N];
        
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(C, 1);
        
        for(int i = 0; i < K; i++) {
            Integer num =  map.get(sushi[i]);
            
            if(num == null) {
                map.put(sushi[i], 1);
            } else {
                map.put(sushi[i], num+1);
            }
        }
        
        int left = 0;
        int right = K - 1;
        
        int answer = map.size();
        for(int i = 0; i < N; i++) {
            right = (right + 1) % N;
            
            Integer num = map.get(sushi[right]);
            
            if(num == null) {
                map.put(sushi[right], 1);
            } else {
                map.put(sushi[right], num+1);
            }
            
            num = map.get(sushi[left]);

            if(num == 1) {
                map.remove(sushi[left]);
            } else {
                map.put(sushi[left], num-1);
            }
            
            answer = Math.max(answer, map.size());
            left++;
        }
        
        System.out.println(answer);
    }
}