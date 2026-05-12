import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        int n = numbers.length;
        String[] arr = new String[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, (s1, s2) -> {
            int first = Integer.parseInt(s1+s2);
            int second = Integer.parseInt(s2+s1);
            if(first == second) return 0;
            else if(first > second) return -1;
            else return 1;
        });
        
        if(Integer.parseInt(arr[0]) == 0) return "0";
        
        for(String str : arr) {
            answer.append(str);
        }
        
        
        return answer.toString();
    }
}