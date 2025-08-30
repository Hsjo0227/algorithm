import java.io.*;
import java.util.*;

class Main {
    static int n, x, y, answer;
    static int[] arr;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        
        if(y - x - 1 > 2 * n) {
            System.out.println(0);
            return;
        }
        
        arr = new int[2 * n + 1];
        used = new boolean[n + 1];
        
        
        arr[x] = arr[y] = y - x - 1;
        used[y-x-1] = true;
        
        answer = 0;
        
        dfs(1, 1);
        
        System.out.println(answer);
        
    }
    
    public static void dfs(int idx, int cnt) {
        if(cnt == n) {
            answer++;
            return;
        }
        
        if(arr[idx] == 0) {
            for(int i = 1; i <= n; i++) {
                if(used[i]) continue;
                if(idx + i + 1 > 2 * n) continue;
                if(arr[idx + i + 1] != 0) continue; 
                
                used[i] = true;
                arr[idx] = i;
                arr[idx + i + 1] = i;
                
                dfs(idx+1, cnt+1);
                
                used[i] = false;
                arr[idx] = 0;
                arr[idx + i + 1] = 0;
            }
        } else {
            dfs(idx+1, cnt);
        }
    }
}