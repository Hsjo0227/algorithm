import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] numberCount = new int[100001];
        int left = 0;
        int right = 0;
        int max = 0;
        
        for(right = 0; right < N; right++) {
            while(numberCount[inputs[right]] >= K) {
                numberCount[inputs[left]]--;
                left++;
            }
            numberCount[inputs[right]]++;
            max = Integer.max(max, right-left+1);
        }
        
        System.out.println(max);
	}
}
