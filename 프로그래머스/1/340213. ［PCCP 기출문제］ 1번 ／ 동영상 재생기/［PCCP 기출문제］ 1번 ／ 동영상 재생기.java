import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int length = toInt(video_len);
        int position = toInt(pos);
        int start = toInt(op_start);
        int end = toInt(op_end);
        
        for(String command : commands) {
            if(start <= position && position <= end) position = end;
            switch(command) {
                case "prev":
                    position = Math.max(0, position - 10);
                    if(start <= position && position <= end) position = end;
                    break;
                case "next":
                    position = Math.min(length, position + 10);
                    if(start <= position && position <= end) position = end;
                    break;

            }
        }
        answer = String.format("%02d:%02d", position / 60, position % 60);
        
        return answer;
    }
    
    public static int toInt(String input) {
        String[] arr = input.split(":");
        int second = Integer.parseInt(arr[1]);
        second += Integer.parseInt(arr[0]) * 60;
        
        return second;
    }
}