import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0});
        boolean[] visited = new boolean[N+1];
        boolean flag = false;
        while(!que.isEmpty()) {
        	int[] now = que.poll();
        	int stair = now[0];
        	int cnt = now[1];
        	int nextA = stair+(stair/2);
        	int nextB = stair+1;
        	if(cnt>K) continue;
        	if(stair==N) {
        		flag = true;
        		break;
        	}
        	if(nextA<=N && !visited[nextA]) {
        		visited[nextA] = true;
        		que.offer(new int[] {nextA,cnt+1});
        	}
        	if(nextB<=N && !visited[nextB]) {
        		que.offer(new int[] {nextB,cnt+1});
        		visited[nextB] = true;
        	}
        }
        System.out.println(flag?"minigimbob":"water");
    }//end main
}