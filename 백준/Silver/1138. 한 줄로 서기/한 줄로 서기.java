import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] inputs = new int[N];
        
        for(int i = 0; i < N; i++) {
        	inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = N-1; i >= 0; i--) {
        	list.add(inputs[i], i+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(list.get(i)).append(" ");
        }
        
        System.out.println(sb);
        
        
    }
}