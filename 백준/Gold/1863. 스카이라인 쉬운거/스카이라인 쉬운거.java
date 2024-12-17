import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offerLast(0);
		
		StringTokenizer st;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 내려가는 부분
			while(deque.peekLast() > y) {
				deque.pollLast();
				cnt++;
			}
			
			// 올라가는 부분
			if(deque.peekLast() < y) deque.offerLast(y);
		}
		cnt += deque.size() - 1;
		
		System.out.println(cnt);
	}
}
