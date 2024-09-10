import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
        int T = 10;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
             
            List<Integer>[] list = new List[V+1];
            for(int i=1; i<=V; i++) list[i] = new ArrayList<>();
            int[] line = new int[V+1];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<E; i++) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                list[A].add(B);
                line[B]++;
            }
            Queue<Integer> que = new LinkedList<Integer>();
            sb.append("#"+t+" ");
            for(int i=1; i<=V; i++) {
                if(line[i]==0) {
                    line[i] = -1;
                    que.offer(i);
                    sb.append(i+" ");
                }
            }
             
            while(!que.isEmpty()) {
                int num = que.poll();
                for(int i : list[num]) {
                    if(--line[i]==0) {
                    	que.offer(i);
                    	sb.append(i+" ");
                    }
                }
            }
            sb.append("\n");
        }//end testcase
        System.out.println(sb);
    }//end main
}