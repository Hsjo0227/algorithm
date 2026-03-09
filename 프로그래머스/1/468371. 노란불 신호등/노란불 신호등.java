import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int lcm = 1;
        for(int[] signal : signals) {
            int sum = signal[0] + signal[1] + signal[2];
            
            lcm = lcm(lcm, sum);
        }
        
        for(int t = 1; t < lcm; t++) {
            boolean flag = true;
            
            for(int[] signal : signals) {
                int G = signal[0];
                int Y = signal[1];
                int R = signal[2];
                
                int cycle = G + Y + R;
                
                int pos = (t-1) % cycle;
                
                if(pos < G || pos >= G + Y) {
                    flag = false;
                    break;
                }
            }
            if(flag) return t;
        }
        return -1;
    }
    
    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}