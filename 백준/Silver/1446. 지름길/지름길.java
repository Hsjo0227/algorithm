import java.io.*;
import java.util.*;

public class Main {
    static class Road implements Comparable<Road>{
        int start;
        int end;
        int distance;
        
        public Road (int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

		public int compareTo(Road o) {
			if(this.start == o.start) {
				Integer.compare(this.distance, o.distance);
			}
			return Integer.compare(this.start, o.start);
		}

		@Override
		public String toString() {
			return "Road [start=" + start + ", end=" + end + ", distance=" + distance + "]";
		}
        
        
    }
    static int answer, N, D;
    static List<Road> list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            
            if(distance > end-start) continue;
            list.add(new Road(start, end, distance));
        }
        Collections.sort(list);
        
        answer = Integer.MAX_VALUE;
        
        dfs(0, 0, 0);
        
        System.out.println(answer);
        
        
    }
    
    public static void dfs(int idx, int distance, int position) {
        if(position > D) return;
        if(distance > answer) return;
        if(idx == list.size()) {
            answer = Math.min(answer, distance+(D-position));
            return;
        }
        
        Road road = list.get(idx);
        
        // 지름길 진입점이 내 앞에 있어서 취하는 경우
        if(road.start >= position) {
           dfs(idx+1, distance+road.distance+(road.start - position), road.end); 
        }
        
        dfs(idx+1, distance, position);
        
    }
}