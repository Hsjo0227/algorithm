import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = points.length;
        int m = routes[0].length;
        int x = routes.length;
        
        int[] curR = new int[x];
        int[] curC = new int[x];
        int[] nextIdx = new int[x];
        boolean[] finished = new boolean[x];
        
        for(int i = 0; i < x; i++) {
            int start = routes[i][0] - 1;
            curR[i] = points[start][0];
            curC[i] = points[start][1];
            nextIdx[i] = 1;
        }
        
        answer += countDanger(curR, curC, finished);
        
        while(true) {
            boolean allFinished = true;
            boolean[] willFinish = new boolean[x];

            for(int i = 0; i < x; i++) {
                if(finished[i]) continue;

                allFinished = false;

                int target = routes[i][nextIdx[i]] - 1;
                int targetR = points[target][0];
                int targetC = points[target][1];

                if(curR[i] < targetR) curR[i]++;
                else if(curR[i] > targetR) curR[i]--;
                else if(curC[i] < targetC) curC[i]++;
                else if(curC[i] > targetC) curC[i]--;

                if(curR[i] == targetR && curC[i] == targetC) {
                    nextIdx[i]++;
                    if(nextIdx[i] == routes[i].length) {
                        willFinish[i] = true;
                    }
                }
            }

            if(allFinished) break;
            answer += countDanger(curR, curC, finished);

            for(int i = 0; i < x; i++) {
                if(willFinish[i]) {
                    finished[i] = true;
                }
            }
        }
        
        return answer;
    }
    
    public static int countDanger(int[] curR, int[] curC, boolean[] finished) {
        int[][] board = new int[101][101];
        int danger = 0;
        
        for(int i = 0; i < curR.length; i++) {
            if(finished[i]) continue;
            board[curR[i]][curC[i]]++;
        }
        
        for(int r = 1; r <= 100; r++) {
            for(int c = 1; c <= 100; c++) {
                if(board[r][c] >= 2) {
                    danger++;
                }
            }
        }
        
        return danger;
    }
}