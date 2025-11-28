import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        
        for(int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }
        
        for(int i = 0; i < M; i++) {
            set2.add(br.readLine());
        }
        
        set1.retainAll(set2);
        
        List<String> answer = new ArrayList<>(set1);
        Collections.sort(answer);
        
        sb.append(answer.size()).append('\n');
        for(String str : answer) {
            sb.append(str).append('\n');
        }
        
        System.out.println(sb);
    }
}