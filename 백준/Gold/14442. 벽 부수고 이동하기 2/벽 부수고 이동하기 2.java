import java.util.*;
import java.io.*;

public class Main {
    static int R,C,K;
    static char[][] arr;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for(int i=0; i<R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int[] dirR = new int[]{0,1,0,-1};
        int[] dirC = new int[]{1,0,-1,0};
        visited = new boolean[R][C][K+1];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,0,1});
        visited[0][0][0] = true;
        int ans = -1;

        while(!que.isEmpty()) {
            int[] now = que.poll();
            int nowR = now[0];
            int nowC = now[1];
            int brokeCnt = now[2];
            int dis = now[3];
//            System.out.println(nowR+" "+nowC+" "+brokeCnt+" "+dis);
            if(nowR==R-1 && nowC==C-1) {
                ans = dis;
                break;
            }
            for(int d=0; d<4; d++) {
                int nr = nowR+dirR[d];
                int nc = nowC+dirC[d];
                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                if(arr[nr][nc]=='1') { //벽이면
                    if(brokeCnt+1>K || isVisitedBefore(nr,nc,brokeCnt)) continue; //부수는 벽이 이전에 부셨던 적이 있으면 패스(BFS는 최단 거리니까 이전에 방문했으면 이미 같은 루트로 간 적이 있는 것이기 떄문)
                    else {
                        visited[nr][nc][brokeCnt]=true;
                        que.offer(new int[] {nr,nc,brokeCnt+1,dis+1});
                    }
                }
                else { //벽이 아니면
                    if(isVisitedBefore(nr,nc,brokeCnt)) continue;
                    visited[nr][nc][brokeCnt] = true;
                    que.offer(new int[] {nr, nc, brokeCnt, dis+1});
                }
            }
        }//end while
        System.out.println(ans);

    }//end main
    public static boolean isVisitedBefore(int r, int c, int brokeCnt) {
        for(int i=0; i<=brokeCnt; i++) {
            if(visited[r][c][i]) {
                return true;
            }
        }
        return false;
    }
}