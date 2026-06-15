import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int num : arr) {
            answer = lcm(answer, num);
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}