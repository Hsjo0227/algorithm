import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<int[]> move(int n, int from, int to) {
        List<int[]> list = new ArrayList<>();
        
        if(n == 1) {
            list.add(new int[] {from, to});
            return list;
        }
        
        int blank = 6 - from - to;
        
        list.addAll(move(n-1, from, blank));
        list.addAll(move(1, from, to));
        list.addAll(move(n-1, blank, to));
        
        
        return list;
    }
    
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        
        list = move(n, 1, 3);
        
        int[][] answer = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}