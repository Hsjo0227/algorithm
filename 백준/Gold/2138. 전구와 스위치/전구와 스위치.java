import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] difference;

    private static void reverse(int[] arr, int i, int num) {
        for (int j = 0; j < num; j++) {
            if (i + j >= N) {
                break;
            }
            arr[i + j] = (arr[i + j] == 0) ? 1 : 0;
        }
    }

    private static int search() {
        int min = 0;
        int count = 0;
        int[] difference2 = Arrays.copyOf(difference, N);

        for (int i = 0; i < N - 1; i++) {
            if (difference[i] == 1) {
                reverse(difference, i, 3);
                count++;
            }
        }
        if (difference[N - 1] == 1) min = -1;
        else min = count;

        reverse(difference2, 0, 2);
        count = 1;
        for (int i = 0; i < N - 1; i++) {
            if (difference2[i] == 1) {
                reverse(difference2, i, 3);
                count++;
            }
        }

        if (difference2[N - 1] != 1) {
            if (min >= 0) {
                min = Math.min(min, count);
            } else {
                min = count;
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] bulbs = new int[N];
        difference = new int[N];
        int answer = 0;

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            bulbs[i] = Character.getNumericValue(s.charAt(i));
        }

        s = br.readLine();
        for (int i = 0; i < N; i++) {
            difference[i] = Math.abs(Character.getNumericValue(s.charAt(i)) - bulbs[i]);
        }

        answer = search();
        System.out.println(answer);

    }
}
