class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length;
        
        int total = 1 << (n-1);
        
        for(int mask = 0; mask < total; mask++) {
            int[] hintCount = new int[n];
            int totalCost = 0;
            
            for(int i = 0; i  < n - 1; i++) {
                if((mask & (1 << i)) == 0) continue;
                
                totalCost += hint[i][0];
                
                for(int j = 1; j < hint[i].length; j++) {
                    int num = hint[i][j];
                    hintCount[num - 1]++;
                } 
            }
            for(int i = 0; i < n; i++) {
                int used = Math.min(hintCount[i], n - 1);
                totalCost += cost[i][used];
            }
            answer = Math.min(answer, totalCost);
        }
        
        return answer;
    }
}