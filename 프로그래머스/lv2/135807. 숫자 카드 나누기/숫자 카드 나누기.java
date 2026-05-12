import java.util.*;

class Solution {
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static boolean check(int a, int[] arr) {
        for(int num : arr) {
            if(num % a == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            if(gcdA == 1) break;
        }
        
        for(int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
            if(gcdB == 1) break;
        }
        
        
        if(check(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }
        if(check(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }
        
        
        return answer;
    }
}