import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			input[i] = num;
		}
		
		for(int i = 0; i < k; i++) {
			int num = input[i];
			if(num == c) continue;
			if(map.get(num)==null) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num)+1);
			}
		}
		int answer = map.size()+1;
		for(int i = 0; i < N; i++) {
			// 선택한 초밥들의 종류
			// 추가할 것
			int num1 = input[(k+i)%N];
			// 뺄 것
			int num2 = input[i];
			
			if(num1 == num2) continue;
			if(num1 != c) {
				if(map.get(num1)==null) {
					map.put(num1, 1);
				} else {
					map.put(num1, map.get(num1)+1);
				}
			}
			if(num2 != c) {
				if(map.get(num2) == 1) {
					map.remove(num2);
				} else {
					map.put(num2, map.get(num2)-1);
				}
			}
			answer = Math.max(answer, map.size()+1);
		}
		System.out.println(answer);
	}
}
