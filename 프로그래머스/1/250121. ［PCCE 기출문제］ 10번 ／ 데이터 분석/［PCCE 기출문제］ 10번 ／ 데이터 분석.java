import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<int[]> list = new ArrayList<>();
        int extIdx = convertToIdx(ext);        
        
        for(int[] arr : data) {
            if(arr[extIdx] < val_ext) {
                list.add(arr);
            }
        }
        int sortIdx = convertToIdx(sort_by);
        
        Collections.sort(list, Comparator.comparingInt(arr -> arr[sortIdx]));
        
        answer = list.toArray(new int[list.size()][]);
        
        return answer;
    }
    
    public static int convertToIdx(String str) {
        switch(str) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
        }
        return -1;
    }
}