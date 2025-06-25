import java.io.*;
import java.util.*;

class Main {
    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                String str = st.nextToken();
                if(str.equals("0")) {
                    sb.append("9");
                } else {
                    sb.append(str);
                }
            }
        }
        
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        
        queue.offer(sb.toString());
        map.put(sb.toString(), 0);
        
        while(!queue.isEmpty()) {
            String present = queue.poll();
            int location = present.indexOf("9");
            int r = location / 3;
            int c = location % 3;
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int move = nr * 3 + nc;
                
                if(nr < 0 || nr >= 3 || nc < 0 || nc >= 3) continue;
                
                StringBuilder next = new StringBuilder(present);
                char temp = next.charAt(move);
                next.setCharAt(location, temp);
                next.setCharAt(move, '9');
                
                String nextStr = next.toString(); 
                if(!map.containsKey(nextStr)) {
                    queue.offer(nextStr);
                    map.put(nextStr, map.get(present) + 1);
                }
            }
        }
        
        if(map.containsKey("123456789")) {
            System.out.println(map.get("123456789"));
        } else {
            System.out.println(-1);
        }
    }
}