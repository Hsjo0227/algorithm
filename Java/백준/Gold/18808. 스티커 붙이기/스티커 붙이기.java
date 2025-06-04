import java.io.*;
import java.util.*;

class Main {
    static int N, M, R, C, answer, count;
    static int[][] board, sticker;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        answer = 0;
        count = 0;
        
        board = new int[N][M];
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            sticker = new int[R][C];
            
            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            paste();
            
            
        }
        System.out.println(answer);
        
    }
    
    public static void paste() {
        for(int k = 0; k < 4; k++) {
            for(int i = 0; i < N-R+1; i++) {
                for(int j = 0; j < M-C+1; j++) {
                    if(check(i, j)) {
                        fill(i, j);
                        return;
                    }
                }
            }
            if(k == 3) break;
            rotate();
        }
    }
    
    public static boolean check(int r, int c) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(sticker[i][j] == 1 && board[i+r][j+c] == 1) return false;
            }
        }
        return true;
    }
    
    public static void fill(int r, int c) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(sticker[i][j] == 1) {
                    board[i+r][j+c] = 1;
                    answer++;
                }
            }
        }
    }
    
    
    
    public static void rotate() {
        int[][] newSticker = new int[C][R];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                newSticker[j][R-i-1] = sticker[i][j];
            }
        }
        int temp = R;
        R = C;
        C = temp;
        sticker = newSticker;
    } 
}