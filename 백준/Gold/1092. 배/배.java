import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] cranes = new int[N];
        for(int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        List<Integer> boxes = new ArrayList<>(M);
        for(int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes);
        
        int answer = 0;
        while(boxes.size() > 0) {
            for(int i = N-1; i >= 0; i--) {
                for(int j = boxes.size() - 1; j >= 0; j--){
                    if(cranes[i] >= boxes.get(j)){
                        boxes.remove(j);
                        break;
                    }
                }
                int size = boxes.size();
                if(size <= 0) break;
                if(boxes.get(size-1) > cranes[N-1]) {
                    System.out.println(-1);
                    return;
                }
            }
            answer++;
        }
        
        
        System.out.println(answer);
    }
}