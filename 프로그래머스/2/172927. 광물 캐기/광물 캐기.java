import java.util.*;

class Solution {
    static int answer;
    static final int[][] power = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        
        int[] mineralsInt = new int[minerals.length];
        for(int i = 0; i < minerals.length; i++) {
            if(minerals[i].equals("diamond")) {
                mineralsInt[i] = 0;
            } else if(minerals[i].equals("iron")) {
                mineralsInt[i] = 1;
            } else {
                mineralsInt[i] = 2;
            }
        }
        
        for(int i = 0; i < 3; i++) {
            if(picks[i] == 0) continue;
            picks[i]--;
            dfs(picks, mineralsInt, 0, i, 0);
            picks[i]++;
        }
        
        return answer;
    }
    
    public void dfs(int[] picks, int[] minerals, int idx, int pick, int sum) {
        int end = Math.min(idx + 5, minerals.length);
        for(int i = idx; i < end; i++) {
            System.out.println(power[pick][minerals[i]]);
            sum += power[pick][minerals[i]];
        }
        System.out.println("====================");
        
            System.out.println(Arrays.toString(picks));
        System.out.println("idx: " + idx + " -> " + end + ", sum: " + sum);
        
        if(sum > answer) return;
        
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            cnt += picks[i];
        }
        if(end == minerals.length || cnt == 0) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(picks[i] <= 0) continue;
            
            picks[i]--;
            System.out.println("call: " + i);
            dfs(picks, minerals, end, i, sum);
            picks[i]++;
        }
        
        
        
    }
}