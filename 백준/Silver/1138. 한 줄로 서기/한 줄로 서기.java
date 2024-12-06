import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        Arrays.fill(heights, -1);

        for(int i=1; i<N+1; i++) {
            int number = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++) {
                if(number == 0 && heights[j] == -1) {
                    heights[j] = i;
                    break;
                }
                if(heights[j] == -1) {number--;}
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            sb.append(heights[i]).append(" ");
        }

        System.out.println(sb);
    }
}