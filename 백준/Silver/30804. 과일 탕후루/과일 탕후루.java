import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int answer = 1;
        int l = 0;
        int r = 1;
        
        map.put(input[l], 1);
        
        while(r < N) {
            Integer right = map.get(input[r]);
            if(right == null) {
                map.put(input[r], 1);
            } else {
                map.put(input[r], right+1);
            }
            
            while(map.keySet().size() > 2) {
                Integer left = map.get(input[l]);
                if(left == 1) {
                    map.remove(input[l]);
                } else {
                    map.put(input[l], left - 1);
                }
                l++;
            }
            
            answer = Math.max(answer, r - l + 1);
            
            r++;
        }
        
        System.out.println(answer);
    }
}