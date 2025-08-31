import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        List<Integer> ten = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(num == 10) {
                answer++;
            } else if(num < 10) {
                continue;
            } else if(num % 10 == 0) {
                ten.add(num);
            } else {
                other.add(num);
            }
        }
        Collections.sort(ten);
        Collections.sort(other);
        
        for(int num : ten) {
            if(M == 0) break;
            int cut = num / 10 - 1;
            
            if(M >= cut) {
                answer += cut+1;
                M -= cut;
            } else {
                answer += M;
                M = 0;
                break;
            }
        }
        
        for(int num : other) {
            if(M == 0) break;
            int cut = num / 10;
            
            if(M >= cut) {
                answer += cut;
                M -= cut;
            } else {
                answer += M;
                M = 0;
                break;
            }
        }
        
        System.out.println(answer);
    }
}