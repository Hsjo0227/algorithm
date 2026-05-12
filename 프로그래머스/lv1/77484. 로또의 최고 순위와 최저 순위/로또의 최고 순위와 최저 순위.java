class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zero = 0;
        int match = 0;
        
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zero++;
            } else {
                for(int j = 0; j < 6; j++) {
                    if(lottos[i] == win_nums[j]) {
                        match++;
                    }
                }
            }
        }
        
        answer[0] = 7 - Math.max(match + zero, 1);
        answer[1] = 7 - Math.max(match, 1);
        
        return answer;
    }
}