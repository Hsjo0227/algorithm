class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int num = brown / 2;
        
        for(int r = 2; r < brown / 2; r++) {
            int c = brown / 2 - r + 2;
            if((r - 2) * (c - 2) == yellow){
                return new int[] {c, r};
            }
        }
        
        
        return answer;
    }
}