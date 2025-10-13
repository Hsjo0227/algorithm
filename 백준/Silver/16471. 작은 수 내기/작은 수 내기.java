import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] card = new int[N];
        int[] opposite = new int[N];
        
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            opposite[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(card);
        Arrays.sort(opposite);
        
        String answer = "NO";
        
        int i = 0;
        int j = 0;
        int win = 0;
        while(i < N && j < N) {
            if(card[i] < opposite[j]) {
                win++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        if(win >= (N+1)/2) answer = "YES";
        
        System.out.println(answer);
    }
}