import java.util.*;

class Solution {
    static int[] purchased;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        purchased = new int[users.length];
        
        dfs(0, users, emoticons);
        
        return answer;
    }
    
    public void dfs(int idx, int[][] users, int[] emoticons) {
        if(idx == emoticons.length) {
            int cnt = 0;
            int money = 0;
            
            
            for(int i = 0; i < users.length; i++) {
                if(purchased[i] >= users[i][1]) {
                    cnt++;
                } else {
                    money += purchased[i];
                }
            }
            
            if(cnt > answer[0]) {
                answer[0] = cnt;
                answer[1] = money;
            } else if(cnt == answer[0]) {
                answer[1] = Math.max(answer[1], money);
            } 
            
            return;
        }
        
        for(int rate = 10; rate <= 40; rate += 10) {
            int price = (emoticons[idx]) / 100 * (100 - rate);
            for(int i = 0; i < users.length; i++) {
                if(rate >= users[i][0]) {
                    purchased[i] += price;
                }
            }
            
            dfs(idx+1, users, emoticons);
            
            for(int i = 0; i < users.length; i++) {
                if(rate >= users[i][0]) {
                    purchased[i] -= price;
                }
            }
        }
    }
}