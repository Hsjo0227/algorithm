import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        int sum = 0;
        
        for(int w : truck_weights) {
            while(sum + w > weight) {
                int[] arr = queue.poll();
                sum -= arr[0];
                time = arr[1];
            }
            if(queue.size() == bridge_length) {
                int[] arr = queue.poll();
                sum -= arr[0];
                time = arr[1];
            }
            
            queue.offer(new int[] {w, time+bridge_length});
            sum += w;
            time++;
            
            while(queue.peek()[1] <= time) {
                int[] arr = queue.poll();
                sum -= arr[0];
            }
        }
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            time = arr[1]+1;
        }
        
        
        return time;
    }
}