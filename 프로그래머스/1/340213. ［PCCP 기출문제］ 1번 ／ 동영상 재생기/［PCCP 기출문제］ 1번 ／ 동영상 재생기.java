class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int lenInt = toInt(video_len);
        int posInt = toInt(pos);
        int startInt = toInt(op_start);
        int endInt = toInt(op_end);
        
        for(String command : commands) {
            if(posInt >= startInt && posInt <= endInt) {
                posInt = endInt;
            }
            switch(command) {
                case "next":
                    posInt = Math.min(posInt + 10, lenInt);
                    break;
                case "prev":
                    posInt = Math.max(posInt - 10, 0);
                    break;
            }
        }
        if(posInt >= startInt && posInt <= endInt) {
                posInt = endInt;
        }
        
        return toStr(posInt);
    }
    
    private int toInt(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    private String toStr(int num) {
        int min = num / 60;
        int sec = num % 60;
        return String.format("%02d:%02d", min, sec);
    }
}