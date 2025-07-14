import java.io.*;
import java.util.*;

class Main {
    static int[] input;
    static int A, B, C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        input = new int[] {A, B, C};
        
        Queue<int[]> queue = new ArrayDeque<>();
        Set<List<Integer>> visited = new HashSet<>();
        
        queue.offer(new int[] {0, 0, C});
        visited.add(Arrays.asList(0, 0, C));
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i == j) continue;
                    
                    int[] next = move(now, i, j);
                    List<Integer> nextList = Arrays.asList(next[0], next[1], next[2]);
                    
                    if(visited.contains(nextList)) continue;
                    
                    visited.add(nextList);
                    queue.offer(next);
                }
            }
        }
        
        Set<Integer> answer = new TreeSet<>();
        for(List<Integer> list : visited) {
            if(list.get(0) == 0) answer.add(list.get(2));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num).append(' ');
        }
        
        System.out.println(sb);
        
        
    }
    
    public static int[] move(int[] arr, int from, int to) {
        int movedWater = Math.min(arr[from], input[to] - arr[to]);
        
        int[] result = Arrays.copyOf(arr, 3);
        result[from] -= movedWater;
        result[to] += movedWater;
        
        return result;
    }
}