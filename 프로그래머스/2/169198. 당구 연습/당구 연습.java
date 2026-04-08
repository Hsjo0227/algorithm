import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int l = balls.length;
        int[] answer = new int[l];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        for(int i = 0; i < l; i++) {
            int[] ball = balls[i];
            int x = ball[0];
            int y = ball[1];
            
            int[] xArr = new int[] {-x, x, 2*m-x, x, -x, -x, 2*m-x, 2*m-x};
            int[] yArr = new int[] {y, -y, y, 2*n-y, -y, 2*n-y, -y, 2*n-y};
            
            int pass = -1;
            
            if(x - startX == 0) {
                if(y < startY) {
                    pass = 1;
                } else {
                    pass = 3;
                }
            } else if(y - startY == 0) {
                if(x < startX) {
                    pass = 0;
                } else {
                    pass = 2;
                }
            } else if(n*x == m*y && n*startX == m*startY) {
                if(x < startX) {
                    pass = 4;
                } else  {
                    pass = 7;
                }
            } else if(n*x + m*y == n*m && n*startX + m*startY == n*m) {
                if(x < startX) {
                    pass = 5;
                } else {
                    pass = 6;
                }
            }
            
            for(int j = 0; j < 8; j++) {
                if(j == pass) continue;
                int dx = startX - xArr[j];
                int dy = startY - yArr[j];
                int distance = dx * dx + dy * dy;
                
                answer[i] = Math.min(answer[i], distance);
            }
        }
        
        return answer;
    }
}