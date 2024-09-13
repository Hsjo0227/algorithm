import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[row][col];
		
		
		char[][] map = new char[row][col];
		for(int i=0; i<row; i++) {
			String str = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') {
					que.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		//end input
		
		
		//BFS
		int[] nearX = new int[] {1,-1,0,0}; 
		int[] nearY = new int[] {0,0,1,-1}; 
		int count = 0;
		
		while(!que.isEmpty()) {
			int[] location = que.poll();
			int nowX = location[0];
			int nowY = location[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + nearX[i];
				int nextY = nowY + nearY[i];
				
				if(nextX<0 || nextX>=row || nextY<0 || nextY>=col) {
					continue;
				}
				if(map[nextX][nextY]!='X' && visited[nextX][nextY]!=true) {
					que.offer(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
					if(map[nextX][nextY]=='P') {
						count++;
					}
				}
			}
			
		}//end while
		
		if(count==0) {
			System.out.println("TT");
		}
		else {
			System.out.println(count);
		}
		
		
	}
}