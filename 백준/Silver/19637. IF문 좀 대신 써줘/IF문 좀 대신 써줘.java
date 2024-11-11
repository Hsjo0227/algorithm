import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num) == null) {
                map.put(num, str);
                list.add(num);
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());
            int idx = Arrays.binarySearch(arr ,input);
            if(idx < 0) {
                sb.append(map.get(arr[-idx-1])).append('\n');
            } else {
                sb.append(map.get(arr[idx])).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}