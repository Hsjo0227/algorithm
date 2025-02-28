import java.util.*;

class Solution {
    static int[] answer;
    static Map<String, Integer> map;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        map = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            int people = map.get(seller[i]);
            int money = amount[i] * 100;
            calc(enroll, referral, people, money);
        }
        
        return answer;
    }
    
    public static void calc(String[] enroll, String[] referral, int idx, int money) {
        if(money == 0) return;
        if(referral[idx].equals("-")) {
            answer[idx] += (int) Math.ceil(money * 0.9);
            return;
        }
        
        answer[idx] += (int) Math.ceil(money * 0.9);
        int ref = map.get(referral[idx]);
        
        calc(enroll, referral, ref, (int) Math.floor(money * 0.1));
        
        
    }
}