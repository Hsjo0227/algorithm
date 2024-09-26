import java.util.*;
import java.io.*;

public class Main { //백준 2638번 치즈
    static int N, M, arr[][];
    static boolean[][] visited;
    static int[] dirR = new int[] {0,1,0,-1};
    static int[] dirC = new int[] {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int cheeseSize = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) cheeseSize++;
            }
        }
        //end input
        int time = 0;
        while(true) {
            if(cheeseSize<=0) break;
            List<int[]> sideCheeseList = findSideCheese();
            for(int[] i : sideCheeseList) arr[i[0]][i[1]] = 0;
            findOutAir();
            cheeseSize -= sideCheeseList.size();
            time++;
        }
        System.out.println(time-1);
    }//end main

    static public List<int[]> findSideCheese() {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]!=1) continue;
                int cnt = 0;
                for(int d=0; d<4; d++) {
                    int nr = i + dirR[d];
                    int nc = j + dirC[d];
                    if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                    if(arr[nr][nc]==2) cnt++;
                }
                if(cnt>=2) {
                    list.add(new int[] {i,j});
                }
            }
        }
        return list;
    }//end findSideCheese

    static public void findOutAir() {
        List<int[]>vacuumList = new ArrayList<>();
        visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0});
        visited[0][0] = true;
        arr[0][0] = 2;

        while(!que.isEmpty()) {
            int[] now = que.poll();
            for(int d=0; d<4; d++) {
                int nr = now[0] + dirR[d];
                int nc = now[1] + dirC[d];
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(visited[nr][nc] || arr[nr][nc]==1) continue;
                visited[nr][nc] = true;
                que.offer(new int[] {nr, nc});
                arr[nr][nc] = 2;
            }
        }//end while
    }//end findVacuum

}