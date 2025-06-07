import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        SortedSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        for(int num : set) {
            sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
}