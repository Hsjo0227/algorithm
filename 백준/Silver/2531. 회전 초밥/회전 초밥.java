import java.util.*;
import java.io.*;

public class Main {
	static int N,M,count;
	static long ans;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //벨트 위의 초밥 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가지 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        
        Deque<Integer> belt = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        
        for(int i=0; i<N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	belt.offer(num);
        	list.add(num);
        }
        //end input
        Set<Integer> set = new HashSet<>();
        Deque<Integer> pick = new LinkedList<>();
        for(int i=0; i<k; i++) {
        	int num = belt.poll();
        	pick.offer(num);
        	belt.offer(num);
        	if(num==c) continue;
        	set.add(num);
        }
        int cnt = set.size();
        //초기값 설정
       for(int i=0; i<N; i++) {
    	   int num = belt.poll();
    	   pick.offer(num);
    	   belt.offer(num);
    	   int del = pick.poll();
    	   if(!pick.contains(del)) {
    		   set.remove(del);
    	   }
    	   if(num==c) continue;
    	   set.add(num);
    	   cnt = Math.max(cnt, set.size());
       }
       System.out.println(cnt+1);
    }//end main
}