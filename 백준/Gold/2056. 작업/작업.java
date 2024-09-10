import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[N+1];
        for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
        int[] taskTimes = new int[N+1];
        int[] indegree = new int[N+1];
        int[] totalTimes = new int[N+1]; // 각 작업이 완료되는 시간

        // 입력 처리
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int taskTime = Integer.parseInt(st.nextToken());
            taskTimes[i] = taskTime;

            int n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) {
                int from = Integer.parseInt(st.nextToken());
                list[from].add(i);
                indegree[i]++;
            }
        }
        
        // 위상 정렬 수행
        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                que.offer(i);
                totalTimes[i] = taskTimes[i]; // 선행 조건 없는 작업의 완료 시간은 자기 작업 시간과 동일
            }
        }

        int result = 0;
        while(!que.isEmpty()) {
            int now = que.poll();

            // 현재 작업의 완료 시간이 전체 시간에 반영됨
            result = Math.max(result, totalTimes[now]);

            // 후속 작업 처리
            for(int next : list[now]) {
                totalTimes[next] = Math.max(totalTimes[next], totalTimes[now] + taskTimes[next]);
                if(--indegree[next] == 0) {
                    que.offer(next);
                }
            }
        }
        
        // 결과 출력
        System.out.println(result);
    }
}