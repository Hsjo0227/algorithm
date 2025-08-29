import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String input = br.readLine();
        
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int answer = 0;
        
        while(right < input.length()) {
            char now = input.charAt(right);
            Integer cnt = map.get(now);
            
            if(cnt == null) {
                map.put(now, 1);
            } else {
                map.put(now, cnt+1);
            }
            right++;
            
            while(map.size() > N) {
                now = input.charAt(left);
                cnt = map.get(now);
                
                if(cnt == 1) {
                    map.remove(now);
                } else {
                    map.put(now, cnt-1);
                }
                left++;
            }
            answer = Math.max(answer, right - left);
        }
        
        System.out.println(answer);
    }
}