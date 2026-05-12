import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int size = friends.length;
        int[] answer_arr = new int[size];
        
        List<String> list = Arrays.asList(friends);
        
        int[][] gift_record = new int[size][size];
        int[] gift_point = new int[size];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] str = gifts[i].split(" ");
            int from = list.indexOf(str[0]);
            int to = list.indexOf(str[1]);
            
            gift_record[from][to]++;
            gift_point[from]++;
            gift_point[to]--;
        }
        
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++) {
                if(i==j) continue;
                
                if(gift_record[i][j] > gift_record[j][i]) answer_arr[i]++;
                else if(gift_record[i][j] < gift_record[j][i]) answer_arr[j]++;
                else {
                    if(gift_point[i] > gift_point[j]) answer_arr[i]++;
                    else if(gift_point[i] < gift_point[j]) answer_arr[j]++;
                }
            }
        }
        answer = Arrays.stream(answer_arr).max().getAsInt();
        return answer;
    }
}