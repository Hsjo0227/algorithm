import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (arr1, arr2) -> {
            if(arr1[0].equals(arr2[0])) {
                return arr1[1].compareTo(arr2[1]);
            } else {
                return arr1[0].compareTo(arr2[0]);
            }
        });
        
        List<Integer> endTimes = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String[] arr : book_time) {
            int start = toMinute(arr[0]);
            int end = toMinute(arr[1]) + 10;
            
            int size = endTimes.size();
            while(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            pq.offer(end);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    private int toMinute(String str) {
        String[] arr = str.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        
        return hour * 60 + minute;
    }
}