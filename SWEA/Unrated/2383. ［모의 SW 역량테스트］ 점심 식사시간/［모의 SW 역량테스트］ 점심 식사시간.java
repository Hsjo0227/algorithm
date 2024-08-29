import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			List<int[]> people = new ArrayList<>();
			List<int[]> stairs = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 1) {
						people.add(new int[] {i, j});
					} else if(num > 1) {
						stairs.add(new int[] {i, j, num});
					}
				}
			}
			
			List<int[]> distance = new ArrayList<>();

			for(int i = 0; i < people.size(); i++) {
				int[] person = people.get(i);
				
				int[] stair = stairs.get(0);
				int d1 = Math.abs(person[0]-stair[0]) + Math.abs(person[1] - stair[1]);
				
				stair = stairs.get(1);
				int d2 = Math.abs(person[0]-stair[0]) + Math.abs(person[1] - stair[1]);
				
				distance.add(new int[] {d1, d2});
			}

			for(int i = 0; i < distance.size(); i++) {
			}
			
			int answer = Integer.MAX_VALUE;
			for(int i = 0; i < (1 << people.size()); i++) {
				// 선택한 사람들과 계단까지의 거리
				Queue<Integer> stair1 = new ArrayDeque<>();
				Queue<Integer> stair2 = new ArrayDeque<>();
				// 부분집합을 이용해 큐에 사람들을 집어넣음
				for(int j = 0; j < people.size(); j++) {
					if((i & (1 << j)) == 0) stair1.offer(distance.get(j)[0]);
					else stair2.offer(distance.get(j)[1]);
				}
				int result = 0;
				// 거리순으로 정렬
				PriorityQueue<Integer> pq = new PriorityQueue<>(stair1);
				Queue<Integer> queue = new ArrayDeque<>();
				int cost = stairs.get(0)[2];
				while(!pq.isEmpty()) {
					// 계단까지 들어가는 시간
					int in = pq.poll() + 1;
					if(queue.size() < 3) {
						// 계단에 나가는 시간을 큐에 넣음
						queue.offer(in + cost);
					} else {
						// 이미 3명이 있으면 큐에서 가장 먼저 나오는 사람을 꺼내서
						int front = queue.poll();
						if(front <= in) {
							// 내가 도착할때 이미 계단에서 탈출 했으면
							queue.offer(in + cost);
						} else {
							queue.offer(front + cost);
						}
					}
				}
				
				while(!queue.isEmpty()) result = queue.poll();
				
				int result2 = 0;
				// 거리순으로 정렬
				pq = new PriorityQueue<>(stair2);
				queue = new ArrayDeque<>();
				cost = stairs.get(1)[2];
				while(!pq.isEmpty()) {
					// 계단까지 들어가는 시간
					int in = pq.poll() + 1;
					if(queue.size() < 3) {
						// 계단에 나가는 시간을 큐에 넣음
						queue.offer(in + cost);
					} else {
						// 이미 3명이 있으면 큐에서 가장 먼저 나오는 사람을 꺼내서
						int front = queue.poll();
						if(front <= in) {
							// 내가 도착할때 이미 계단에서 탈출 했으면
							queue.offer(in + cost);
						} else {
							queue.offer(front + cost);
						}
					}
				}
				
				while(!queue.isEmpty()) result2 = queue.poll();
				
				result = Math.max(result, result2);
				answer = Math.min(result, answer);
			}
			System.out.printf("#%d %d\n", tc, answer);
			
		}
	}

}
