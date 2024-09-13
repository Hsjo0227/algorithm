import java.util.*;
import java.io.*;

public class Main {
	static int N, arr[][], start[], sec;
	static int sharkSize = 2;
	static int eatingCnt = 0;
	static int[] dirR = new int[] {-1,0,1,0};
	static int[] dirC = new int[] {0,-1,0,1};

	public static class Fish implements Comparable<Fish>{
		int r, c,size;

		public Fish(int r, int c, int size) {
			super();
			this.size = size;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		arr[i][j] = num;
        		if(num==9) {
        			start = new int[] {i,j};
        			arr[i][j] = 0;
        		}
        	}
        }
        //end input
        
        while(true) {
        	Fish shark = new Fish(start[0],start[1],sharkSize);
        	int time = findNextFish(shark);
        	if(time==0) break;
        	
        	Fish targetFish = checkChoice(shark, time);
        	start[0] = targetFish.r;
        	start[1] = targetFish.c;
        	arr[targetFish.r][targetFish.c] = 0;
        	eatingCnt++;
        	if(eatingCnt==sharkSize) {
        		sharkSize++;
        		eatingCnt=0;
        	}
        	
        	sec += time;
        }
        System.out.println(sec);
    }//end main
    
    static public int findNextFish(Fish shark) {
    	boolean[][] visited = new boolean[N][N];
    	Queue<int[]> que = new LinkedList<>();
    	que.offer(new int[] {shark.r,shark.c,0});
    	visited[shark.r][shark.c] = true;
    	
    	while(!que.isEmpty()) {
    		int[] now = que.poll();
    		int nowR = now[0];
    		int nowC = now[1];
    		int nowTime = now[2];
    		if(arr[nowR][nowC]>0 && arr[nowR][nowC]<shark.size) {
    			return nowTime;
    		}
    		for(int d=0; d<4; d++) {
    			int nr = dirR[d]+nowR;
    			int nc = dirC[d]+nowC;
    			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
    			if(visited[nr][nc] || arr[nr][nc]>shark.size) continue;
    			visited[nr][nc] = true;
    			que.offer(new int[] {nr, nc, nowTime+1});
    		}
    	}//end while
    	return 0;
    }
    
    //가장 가까운 애들 중에 위쪽과 왼쪽에 있는 애를 고름
    static public Fish checkChoice(Fish shark, int limit) {
    	boolean[][] visited = new boolean[N][N];
    	Queue<int[]> que = new LinkedList<>();
    	que.offer(new int[] {shark.r,shark.c,0});
    	visited[shark.r][shark.c] = true;
    	
    	List<Fish> fishList = new ArrayList<>();
    	while(!que.isEmpty()) {
    		int[] now = que.poll();
    		int nowR = now[0];
    		int nowC = now[1];
    		int nowTime = now[2];
    		
    		if(nowTime>limit) continue; //거리를 넘으면 패스
    		if(arr[nowR][nowC]>0 && arr[nowR][nowC]<shark.size) { //거리안에 있고, 상어보다 사이즈가 작으면 리스트에 추가
    			fishList.add(new Fish(nowR, nowC, arr[nowR][nowC]));
    		}
    		for(int d=0; d<4; d++) {
    			int nr = dirR[d]+nowR;
    			int nc = dirC[d]+nowC;
    			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
    			if(visited[nr][nc] || arr[nr][nc]>shark.size) continue;
    			visited[nr][nc] = true;
    			que.offer(new int[] {nr, nc, nowTime+1});
    		}
    	}//end while
    	Collections.sort(fishList);
    	return fishList.get(0);
    }
}