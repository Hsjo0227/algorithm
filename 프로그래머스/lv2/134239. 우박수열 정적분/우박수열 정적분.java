import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        int[] arr = new int[201];
        arr[0] = k;
        int n = 0;
        
        for(int i = 0; i < 200; i++) {
            if(arr[i] == 1) {
                n = i;
                break;
            }
            
            if(arr[i] % 2 == 0) {
                arr[i+1] = arr[i] / 2;
            } else {
                arr[i+1] = arr[i] * 3 + 1;
            }
            System.out.println(arr[i+1]);
        }
        
        double[] area = new double[n+1];
        
        for(int i = 1; i <= n; i++) {
            area[i] = (double) (arr[i] + arr[i - 1]) / 2 + area[i - 1];
        }
        
        for(int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int start = range[0];
            int end = n + range[1];
            
            if(start > end || start > n) {
                answer[i] = -1;
            } else {
                answer[i] = area[end] - area[start];
            }
        }
        
        return answer;
    }
}