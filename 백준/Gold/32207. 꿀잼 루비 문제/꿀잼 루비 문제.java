import java.io.*;
import java.util.*;

class Main {
    static int N, M, K, answer, limit;
    static List<Ruby> list, selected;
    
    static class Ruby implements Comparable<Ruby> {
        int r;
        int c;
        int amount;
        
        public Ruby(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
        
        @Override
        public int compareTo(Ruby o) {
            return -Integer.compare(this.amount, o.amount);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Ruby> input = new ArrayList<>();
        list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                input.add(new Ruby(i, j, num));
            }
        }
        Collections.sort(input);
        limit = Math.min(N * M, 5 * K);
        for(int i = 0; i < limit; i++) {
            list.add(input.get(i));
        }
        
        selected = new ArrayList<>();
        
        dfs(0, 0, 0);
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int point, int cnt) {
        if(idx >= limit) {
            answer = Math.max(answer, point);
            return;
        }
        
        if(cnt == K) {
            answer = Math.max(answer, point);
            return;
        }
        
        Ruby now = list.get(idx);
        
        boolean flag = false;
        for(Ruby next : selected) {
            int diff = Math.abs(now.r - next.r) + Math.abs(now.c - next.c);
            if(diff == 1) {
                flag = true;
                break;
            }
        }
        
        
        if(!flag) {
            selected.add(now);
            dfs(idx+1, point + now.amount, cnt+1);
            selected.remove(now);
        }
        dfs(idx+1, point, cnt);
    }
}