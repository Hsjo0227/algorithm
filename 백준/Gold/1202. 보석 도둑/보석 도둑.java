import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] jewels = new int[N][2];
		int[] bag = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			jewels[i][0] = Integer.parseInt(st.nextToken());
			jewels[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewels, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long result = 0;
		
		int j = 0;
		for(int i = 0; i < K; i++) {
			while(j < N && jewels[j][0] <= bag[i]) {
				pq.offer(jewels[j][1]);
				j++;
			}
			
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		
		System.out.println(result);
	}
}
