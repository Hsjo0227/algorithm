import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] input = new int[K];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < K; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        Set<Integer> set = new HashSet<>();
        
        int answer = 0;
        for(int i = 0; i < K; i++) {
            int cur = input[i];
            
            if(set.contains(cur)) continue;
            
            if(set.size() < N) {
                set.add(cur);
                continue;
            }
            
            int maxIdx = i;
            int target = input[i];
            for(int plug : set) {
                int next = Integer.MAX_VALUE;
                for(int j = i+1; j < K; j++) {
                    if(input[j] == plug) {
                        next = j;
                        break;
                    }
                }
                
                if(next > maxIdx) {
                    maxIdx = next;
                    target = plug;
                }
                
                
            }
            set.remove(target);
            set.add(cur);
            answer++;
        }
        System.out.println(answer);
    }
}