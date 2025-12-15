import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int answer = 0;
        
        for(int num : arr) {
            Integer h = map.floorKey(num);
            if(h == null) {
                map.merge(1, 1, Integer::sum);
                answer++;
            } else {
                int cnt = map.get(h);
                if(cnt == 1) map.remove(h);
                else map.put(h, cnt - 1);
                
                map.merge(h + 1, 1, Integer::sum);
            }
        }
        
        System.out.println(answer);
    }
}