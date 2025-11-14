import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int countButtonHit(int currentChannel) {
//        int result;
//        if (currentChannel == 0) {
//            result = 1;
//        } else {
//            result = (int) Math.log10(currentChannel) + 1;
//        }
        int result = currentChannel == 0 ? 1 : (int) Math.log10(currentChannel) + 1;

        result += Math.abs(N - currentChannel);
        return result;
    }

    static boolean containsChar(String str, char[] arr) {
        for (char c : arr) {
            if (str.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] brokenButtons = new char[M];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < M; i++) {
                brokenButtons[i] = st.nextToken().charAt(0);
            }
        }

        int min = countButtonHit(100) - 3;


        for (int i = 0; i < 1000000; i++) {
            if (containsChar(Integer.toString(i), brokenButtons)) {
                continue;
            }
            int current = countButtonHit(i);
            min = Math.min(min, current);

        }
        System.out.println(min);
    }
}
