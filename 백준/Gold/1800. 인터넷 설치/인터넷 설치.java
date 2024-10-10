import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nComputer = Integer.parseInt(st.nextToken());
        int nCable = Integer.parseInt(st.nextToken());
        int nFree = Integer.parseInt(st.nextToken());

        Network network = new Network(nComputer, nCable, nFree);

        for (int i = 0; i < nCable; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            network.addCable(src, des, cost);
        }

        System.out.println(network.getAnswer());
    }
}

class Network {
    List<Cable>[] cables;
    int nComputer;
    int nCable;
    int nFree;

    int maxCost = 0;

    class Cable {
        int des;
        int cost;

        Cable(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }

    class Linked {
        int des;
        int nOver;

        Linked(int des, int nOver) {
            this.des = des;
            this.nOver = nOver;
        }
    }

    Network(int nComputer, int nCable, int nFree) {
        cables = new List[nComputer + 1];
        this.nComputer = nComputer;
        this.nCable = nCable;
        this.nFree = nFree;

        for (int c = 1; c <= nComputer; c++) {
            cables[c] = new ArrayList<>();
        }
    }

    public void addCable(int src, int des, int cost) {
        cables[src].add(new Cable(des, cost));
        cables[des].add(new Cable(src, cost));
        maxCost = Math.max(maxCost, cost);
    }

    public int getAnswer() {
        int result = parametricSearch(0, maxCost);

        return result > maxCost ? -1 : result;
    }

    private int parametricSearch(int low, int high) {
        if (low > high)
            return low;

        int cost = (low + high) / 2;

        if (isPossibleCost(cost)) {
            return parametricSearch(low, cost - 1);
        } else {
            return parametricSearch(cost + 1, high);
        }
    }

    private boolean isPossibleCost(int cost) {
        int[] dp = new int[nComputer + 1];
        Deque<Linked> deque = new LinkedList<>();

        deque.add(new Linked(1, 0));
        Arrays.fill(dp, nFree + 1);
        dp[1] = 0;
        while (!deque.isEmpty()) {
            Linked cur = deque.pollFirst();

            if (dp[cur.des] < cur.nOver)
                continue;

            for (Cable next : cables[cur.des]) {
                if (next.cost <= cost && dp[next.des] > cur.nOver) {
                    if (next.des == nComputer)
                        return true;

                    dp[next.des] = cur.nOver;
                    deque.addFirst(new Linked(next.des, cur.nOver));
                    continue;
                }

                if (next.cost > cost && dp[next.des] > cur.nOver + 1) {
                    if (nFree < cur.nOver + 1)
                        continue;

                    if (next.des == nComputer)
                        return true;

                    dp[next.des] = cur.nOver + 1;
                    deque.addLast(new Linked(next.des, cur.nOver + 1));
                }
            }
        }

        return false;
    }
}