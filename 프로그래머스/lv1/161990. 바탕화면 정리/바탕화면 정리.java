class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int R = wallpaper.length;
        int C = wallpaper[0].length();
        
        
        int maxR = 0;
        int minR = R;
        int maxC = 0;
        int minC = C;
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(wallpaper[i].charAt(j) == '.') continue;
                
                maxR = Math.max(maxR, i + 1);
                minR = Math.min(minR, i);
                maxC = Math.max(maxC, j + 1);
                minC = Math.min(minC, j);
            }
        }
        
        answer = new int[] {minR, minC, maxR, maxC};
        
        return answer;
    }
}