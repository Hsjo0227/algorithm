import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for(int i=0; i<R; i++) {
        	char[] nums = br.readLine().toCharArray();
        	for(int j=0; j<C; j++) {
        		map[i][j] = Integer.parseInt(String.valueOf(nums[j]));
        	}
        }//end input
        //출발과 시작이 같은 경우 종료.
        if(R==1 && C==1) {
        	System.out.println(1); 
        	System.exit(0);
        }
        
        int res = 0;
        int [][][] visited = new int [2][R][C];
        Queue<int[]> que = new LinkedList<>();
        
        que.offer(new int[] {0,0,0});
        visited[0][0][0] = 1;
        int[] dirX = new int[] {-1,1,0,0};
        int[] dirY = new int[] {0,0,-1,1};
        
        loop:
        while(true) {
        	int[] location = que.poll();
        	int nowW = location[0];
        	int nowX = location[1];
        	int nowY = location[2];
        	
        	for(int i=0; i<4; i++) {
        		int nextX = nowX+dirX[i];
        		int nextY = nowY+dirY[i];
        		if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
        			continue;
        		}
        		if(visited[nowW][nextX][nextY]==0 && map[nextX][nextY] == 0) {
        			que.offer(new int[] {nowW, nextX,nextY});
        			visited[nowW][nextX][nextY] = visited[nowW][nowX][nowY]+1;
        			if(nextX == R-1 && nextY == C-1) {
        				res = visited[nowW][nextX][nextY];
        				break loop;
        			}
        		}
        		else if(nowW==0 && visited[1][nextX][nextY]==0 && map[nextX][nextY]==1) {
        			que.offer(new int[] {1, nextX, nextY});
        			visited[1][nextX][nextY] = visited[0][nowX][nowY]+1;
        			if(nextX==R-1 && nextY==C-1) {
        				res = visited[1][nextX][nextY];
        				break loop;
        			}
        		}
        	}//end for
        	if(que.isEmpty()) {
        		System.out.println(-1);
        		System.exit(0);
        	}
        }//end while
		System.out.println(res);
    }//end main
}