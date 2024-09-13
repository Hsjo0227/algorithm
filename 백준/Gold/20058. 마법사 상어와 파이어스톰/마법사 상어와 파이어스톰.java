import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] after;
    static boolean[][] visited;
    static List<int[]> delList;
    static int[] dirR = new int[] {-1,1,0,0};
    static int[] dirC = new int[] {0,0,-1,1};
    static int N;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = (int)Math.pow(2,Integer.parseInt(st.nextToken()));
        int Q = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        after = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());


        int[] Ls = new int[Q];
        for(int i=0; i<Q; i++) {
            Ls[i] = Integer.parseInt(st.nextToken());
        }

        for(int q=0; q<Q; q++) {
            L = (int)Math.pow(2,Ls[q]);
            if(L == 0) continue;

            for(int i=0; i<N; i=i+L) {
                for(int j=0; j<N; j=j+L) {
                    spin(i,j);
                }
            }
            check();
        }//end Q

        int cnt = 0;
        int sum = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(after[i][j]>0 ) {
                    sum+=after[i][j];
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        cnt = Math.max(cnt, bfs(i, j));
                    }
                }
            }
        }
        System.out.println(sum);
        System.out.println(cnt);
    }//end main

    public static int bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        int cnt = 1;

        while(!que.isEmpty()) {
            int[] now = que.poll();
            for(int k=0; k<4; k++) {
                int nextR = now[0]+dirR[k];
                int nextC = now[1]+dirC[k];
                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) continue;
                if(after[nextR][nextC]>0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    que.offer(new int[]{nextR, nextC});
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static void spin(int r, int c) {
        int originR = r;
        int originC = c;
        for(int i=L+c-1; i>=c; i--) {
            for(int j=r; j<L+r; j++) {
                after[j][i] = map[originR][originC++];
            }
            originC = c;
            originR++;
        }
    }//end spin

    public static void check() {
        delList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int cnt=0;
                for(int k=0; k<4; k++) {
                    int nextR = i+dirR[k];
                    int nextC = j+dirC[k];
                    if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) continue;
                    if(after[nextR][nextC]<=0) continue;
                    cnt++;
                }
                if(cnt<3) delList.add(new int[] {i,j});
            }
        }
        delList.stream().forEach(o -> after[o[0]][o[1]]-- );
        for(int i=0; i<N; i++) {
            map[i] = after[i].clone();
        }
    }//end check;

}