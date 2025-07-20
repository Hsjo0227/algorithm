import java.io.*;
import java.util.*;

class Main {
    static int N, C;
    static int[] home;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        home = new int[N];
        
        for(int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(home);
        
        int left = 1;
        int right = home[N-1] - home[0];
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
        
    }
    
    public static boolean check(int d) {
        int cnt = 1;
        int prev = home[0];
        
        for(int i = 1; i < N; i++) {
            int now = home[i];
            if((now - prev) >= d) {
                cnt++;
                prev = now;
                
                if(cnt == C) return true;
            }
        }
        return false;
    }
}