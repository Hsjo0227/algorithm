import java.util.*;

class Solution {
    static int answer, n;
    static int[] arr;
    static final int[][] power = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };

    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        n = minerals.length;

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            String str = minerals[i];
            if (str.equals("diamond")) arr[i] = 0;
            else if (str.equals("iron")) arr[i] = 1;
            else arr[i] = 2;
        }

        dfs(picks, 0, 0);
        return answer;
    }

    public void dfs(int[] picks, int idx, int sum) {
        if (idx >= n) {
            answer = Math.min(answer, sum);
            return;
        }

        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            answer = Math.min(answer, sum);
            return;
        }

        if (sum >= answer) return;

        for (int pick = 0; pick < 3; pick++) {
            if (picks[pick] == 0) continue;

            int cost = 0;
            for (int i = idx; i < idx + 5 && i < n; i++) {
                cost += power[pick][arr[i]];
            }

            picks[pick]--;
            dfs(picks, idx + 5, sum + cost);
            picks[pick]++;
        }
    }
}