import java.io.*;
import java.util.*;

class Main {
    static final int[] score = {
        0, 2, 4, 6, 8, 10, 12, 14, 16, 18,
        20, 22, 24, 26, 28, 30, 32, 34, 36, 38,
        40, 0,
        13, 16, 19,
        25, 30, 35,
        22, 24,
        28, 27, 26
    };
    static int[][] next = new int[33][2];
    static int[] input;
    static int answer = 0;
    static int[] pieces;
    static boolean[] occupied;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[10];
        
        for(int i = 0; i < 10; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        // 두번째 인덱스는 화살표가 파란색, 빨간색으로 연결되어있는지를 표시함
        for(int i = 0; i < 33; i++) {
            next[i][0] = -1;
            next[i][1] = -1;
        }
        
        for(int i = 0; i < 20; i++) {
            next[i][1] = i + 1;
        }
        next[20][1] = 21;
        next[21][1] = 21;
        
        next[5][0] = 22;
        next[10][0] = 28;
        next[15][0] = 30;
        
        next[22][1] = 23;
        next[23][1] = 24;
        next[24][1] = 25;
        
        next[25][1] = 26;
        next[26][1] = 27;
        next[27][1] = 20;
        
        next[28][1] = 29;
        next[29][1] = 25;
        
        next[30][1] = 31;
        next[31][1] = 32;
        next[32][1] = 25;
        
        pieces = new int[4];
        occupied = new boolean[33];
        dfs(0, 0);
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int point) {
        if(idx == 10) {
            answer = Math.max(answer, point);
            return;
        }
        
        int roll = input[idx];
        
        for(int i = 0; i < 4; i++) {
            int cur = pieces[i];
            if(cur == 21) continue;
            int next = move(cur, roll);
            if(next != 21 && occupied[next]) continue;
            
            occupied[cur] = false;
            occupied[next] = true;
            pieces[i] = next;
            
            dfs(idx + 1, point + score[next]);
            
            pieces[i] = cur;
            occupied[next] = false;
            occupied[cur] = true;
        }
    }
    
    public static int move(int pos, int roll) {
        if(pos == 21) return 21;
        int nextPos = (next[pos][0] != -1 ? next[pos][0] : next[pos][1]);
        
        for(int i = 1; i < roll; i++) {
            if(nextPos == 21) return 21;
            nextPos = next[nextPos][1];
        }
        
        return nextPos;
    }
}