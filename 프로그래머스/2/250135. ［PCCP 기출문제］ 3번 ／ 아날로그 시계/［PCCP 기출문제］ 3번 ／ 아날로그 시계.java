class Solution {
    static final int full = 12 * 60 * 60;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        int cnt = 0;
        
        if(overlap(start)) cnt++;
        
        for(int time = start; time < end; time++) {
            cnt += alert(time);
        }
        
        return cnt;
    }
    
    private int alert(int time) {
        int cnt = 0;
        
        int hPos = getHourPos(time);
        int mPos = getMinPos(time);
        int sPos = getSecPos(time);
        
        int nextHPos = getHourPos(time + 1);
        int nextMPos = getMinPos(time + 1);
        int nextSPos = getSecPos(time + 1);
    
        
        int hGap = (hPos - sPos + full) % full;
        int mGap = (mPos - sPos + full) % full;
        
        boolean meetHour = 0 < hGap && hGap <= 719;
        boolean meetMin = 0 < mGap && mGap <= 708;

        if (meetHour) cnt++;
        if (meetMin) cnt++;

        if (meetHour && meetMin && nextHPos == nextMPos && nextMPos == nextSPos) {
            cnt--;
        }
        
        return cnt;
    }
    
    private boolean overlap(int time) {
        int hPos = getHourPos(time);
        int mPos = getMinPos(time);
        int sPos = getSecPos(time);
        
        if(sPos == hPos || sPos == mPos) return true;
        
        return false;
    }
    
    private int getHourPos(int time) {
        return time % full;
    }
    private int getMinPos(int time) {
        return (time * 12) % full;
    }
    private int getSecPos(int time) {
        return (time * 12 * 60) % full;
    }
    
    
}