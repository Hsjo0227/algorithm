import java.util.*;


class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int n, m;
    boolean[][] visited;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'X') continue;
                if(visited[i][j]) continue;
                list.add(bfs(maps, i, j));
            }
        }
        
        if(list.size() == 0) return new int[] {-1};
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int bfs(String[] map, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            r = arr[0];
            c = arr[1];
            
            cnt += map[r].charAt(c) - '0';
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(map[nr].charAt(nc) == 'X') continue;
                if(visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
            
        }
        return cnt;
    }
    
}