import java.util.*;
import java.io.*;

public class Main { 
	static int ans = Integer.MAX_VALUE , arr[][];
	static int[] dirR = new int[]{0,1,0,-1};
	static int[] dirC = new int[]{1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];
        for(int i=0; i<5; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<5; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr[R][C] = -1;
        recur(R,C,0,0);
        
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
        
    }//end main
    
    static public void recur(int r, int c, int dis, int apple) {
    	if(apple==3) {
    		if(dis<ans) ans = dis;
    		return;
    	}
    	for(int d=0; d<4; d++) {
    		int nr = r+dirR[d];
    		int nc = c+dirC[d];
    		if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
    		if(arr[nr][nc] == -1) continue;
    		
    		if(arr[nr][nc]==1) {
    			arr[nr][nc] = -1;
    			recur(nr, nc, dis+1, apple+1);
    			arr[nr][nc] = 1;
    		}
    		else {
    			arr[nr][nc] = -1;
    			recur(nr, nc, dis+1, apple);
    			arr[nr][nc] = 0;
    		}
    	}
    	
    }
}
