import java.io.*;
import java.util.*;

class Main {
    static int N, answer;
    static List<Egg> eggs;
    //static int[][] eggs;
    
    static class Egg {
        int d;
        int w;
        
        public Egg(int d, int w) {
            this.d = d;
            this.w = w;
        }
        
        public String toString() {
            return "d: "+d+", w: " +  w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        // eggs = new int[N][2];
        eggs = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(d, w));
        }
        
        dfs(0);
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx) {
        if(idx == N) {
            int count = 0;
            for(int i = 0; i < N; i++) {
                if(eggs.get(i).d <= 0) count++;
            }
            
            answer = Integer.max(answer, count);
            return;
        }
        
        Egg hand = eggs.get(idx);
        
        if(hand.d <= 0) {
            dfs(idx+1);
            return;
        }
        
        boolean hasTarget = false;
        for(int i = 0; i < N; i++) {
            if(i != idx && eggs.get(i).d > 0) {
                hasTarget = true;
                break;
            }
        }
        if(!hasTarget) {
            dfs(idx+1);
            return;
        }
        
        
        for(int i = 0; i < N; i++) {
            if(i == idx) continue;
            
            Egg egg = eggs.get(i);
            
            if(egg.d <= 0) continue;
            
            Egg nextHand = new Egg(hand.d - egg.w, hand.w);
            Egg nextEgg = new Egg(egg.d - hand.w, egg.w);
            
            eggs.set(idx, nextHand);
            eggs.set(i, nextEgg);
            
            dfs(idx+1);
            
            eggs.set(idx, hand);
            eggs.set(i, egg);
        }
    }
}