import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        Queue<Integer>[] time = new Queue[k+1];
        Arrays.setAll(time, i -> new ArrayDeque<>());
        
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n-k+1; j++) {
                time[i].offer(calculateTime(i, j, reqs));
            }
        }
        
        int answer = 0;
        int cnt = 1;
        int[] currentTime = new int[k+1];
        
        for(int i = 1; i <= k; i++) {
            currentTime[i] += time[i].poll();
        }
        
        for(int i = 1; i <= n-k; i++) {
            System.out.println(Arrays.toString(currentTime));
            int maxDiff = 0;
            int maxIndex = -1;
            for(int j = 1; j <= k; j++) {
                int diff = currentTime[j] - time[j].peek();
                if(maxDiff <= diff) {
                    maxDiff = diff;
                    maxIndex = j;
                }
            }
            System.out.println(maxIndex);
            currentTime[maxIndex] = time[maxIndex].poll();
        }
        
        for(int num : currentTime) {
            answer += num;
        }
        
        return answer;
    }
    
    public static int calculateTime(int type, int people, int[][] reqs) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < reqs.length; i++) {
            if(reqs[i][2] != type) continue;
            
            if(pq.size() < people) {
                pq.offer(reqs[i][0]+reqs[i][1]);
            } else {
                int endTime = pq.poll();
                int start = Math.max(endTime, reqs[i][0]);
                if(start > reqs[i][0]) answer += start - reqs[i][0];
                pq.offer(start + reqs[i][1]);

            }
        }

        return answer;
    }
}