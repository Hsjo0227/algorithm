import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static long[] arr;
    static int minGuitar;
    static long maxSong;
    
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new long[N];
        minGuitar = Integer.MAX_VALUE;
        maxSong = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String str = st.nextToken();
            
            str = str.replace('Y', '1');
            str = str.replace('N', '0');
            
            arr[i] = Long.parseLong(str, 2);
            maxSong |= arr[i];
        }
        
        if(maxSong == 0L) {
            System.out.println(-1);
            return;
        } 
        
        dfs(0, 0, 0);
        dfs(0, 1, arr[0]);
        
        System.out.println(minGuitar);
    }
    
    public static void dfs(int idx, int cnt, long song) {
        if(maxSong == song) {
            minGuitar = Math.min(cnt, minGuitar);
        }
        if(idx + 1 == N) return;
        
        dfs(idx + 1, cnt, song);
        
        long next = (song | arr[idx + 1]);
        if(next != song) {
            dfs(idx + 1, cnt + 1, next);
        }
    }
}