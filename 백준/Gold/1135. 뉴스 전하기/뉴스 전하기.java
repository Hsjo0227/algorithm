import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++) adj.add(new ArrayList<>());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            adj.get(num).add(i);
        }
        
        System.out.println(dfs(0));
        
    }
    
    public static int dfs(int num) {
        if(adj.get(num).isEmpty()) return 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int child : adj.get(num)) {
            list.add(dfs(child));
        }
        
        list.sort(Collections.reverseOrder());
        
        int time = 0;
        for(int i = 0; i < list.size(); i++) {
            time = Math.max(time, list.get(i) + i + 1);
        }
        
        return time;
    }
}