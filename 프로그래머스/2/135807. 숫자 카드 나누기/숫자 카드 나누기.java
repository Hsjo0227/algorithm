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
    
    public static int gcd(int[] arr) {
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if(result == 1) break;
        }
        return result;
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
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        
        if(check(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }
        if(check(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
}