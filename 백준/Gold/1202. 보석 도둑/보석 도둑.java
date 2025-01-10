import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1202번 - 보석 도둑
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((e1, e2) -> {
            return e2[1] - e1[1];
        });

        int[][] jewels = new int[N][2];
        int[] bags = new int[K];
        long result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (j1, j2) -> {
            return j1[0] - j2[0];
        });

        Arrays.sort(bags);

        int j = 0;
        for (int i = 0; i < K; i++) {
            int bagCapaicty = bags[i];

            while (j < N) {
                if (bagCapaicty >= jewels[j][0]) {
                    priorityQueue.add(jewels[j]);
                } else {
                    break;
                }
                j++;
            }
            if(!priorityQueue.isEmpty()){
                result += priorityQueue.poll()[1];
            }
        }

        System.out.println(result);
    }
}
