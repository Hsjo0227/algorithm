class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int current = health - attacks[0][1];
        if(current <= 0) return -1;
        
        for(int i = 1; i < attacks.length; i++) {
            int time = attacks[i][0] - attacks[i-1][0] - 1;
            int heal = time / t * y + time * x;
            current = Math.min(health, current + heal);
            
            current -= attacks[i][1];
            
            if(current <= 0) return -1;
        }
        
        return current;
    }
}