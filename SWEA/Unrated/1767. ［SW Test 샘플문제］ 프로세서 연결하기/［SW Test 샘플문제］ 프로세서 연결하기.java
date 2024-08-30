import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    final static int[] dr = {-1, 1, 0, 0};
    final static int[] dc = {0, 0, -1, 1};
    static int N;
    static boolean[][] board;
    static List<Processor> processors;
    static int answer;
    
    static class Processor {
        int r;
        int c;
        public Processor(int r, int c) {
            this.r = r;
            this.c = c;
        }    
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new boolean[N][N];
            processors = new ArrayList<>();
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 1) {
                        board[i][j] = true;
                        if(i > 0 && i < N-1 && j > 0 && j < N-1) processors.add(new Processor(i, j));
                    }
                }
            }
            answer = Integer.MAX_VALUE;
            for(int i = processors.size(); i >= 1; i--) {
                combination(0, 0, new boolean[processors.size()], i);
                if(answer != Integer.MAX_VALUE) break;
            }
            
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

    public static void drawLine(List<Processor> selected, int idx, int wireLength) {
        if(idx == selected.size()) {
            answer = Math.min(answer, wireLength);
            return;
        }
        
        Processor processor = selected.get(idx);
        
        for(int dir = 0; dir < 4; dir++) {
            int r = processor.r;
            int c = processor.c;
            
            boolean flag = false;
            int len = 0;
            while(true) {
                r = r + dr[dir];
                c = c + dc[dir];
                
                if(r < 0 || r >= N || c < 0 || c >= N) {
                    flag = true;
                    break;
                }
                
                if(board[r][c]) {
                    break;
                }
                board[r][c] = true;
                len++;
            }
            
            if(flag) {
                drawLine(selected, idx+1, wireLength+len);
            }

            r = processor.r;
            c = processor.c;

            for(int i = 0; i < len; i++) {
                r = r + dr[dir];
                c = c + dc[dir];
                board[r][c] = false;
            }
        }
    }
    
    public static void combination(int cnt, int start, boolean[] selected, int r) {
        if(cnt == r) {
            List<Processor> selectedProcessors = new ArrayList<>();
            for(int i = 0; i < processors.size(); i++) {
                if(selected[i]) {
                    selectedProcessors.add(processors.get(i));
                }
            }
            drawLine(selectedProcessors, 0, 0);
            return;
        }
        for(int i = start; i < processors.size(); i++) {
            selected[i] = true;
            combination(cnt + 1, i + 1, selected, r);
            selected[i] = false;
        }
    }
}
