import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int n, m;

    public int solution(String[] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length();

        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                if (board[r].charAt(c) == 'G') {
                    return depth;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int[] next = move(board, r, c, dir);

                    int nr = next[0];
                    int nc = next[1];

                    if (visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    queue.offer(next);
                }
            }

            depth++;
        }

        return -1;
    }

    public int[] move(String[] board, int r, int c, int dir) {
        while (true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                return new int[] {r, c};
            }

            if (board[nr].charAt(nc) == 'D') {
                return new int[] {r, c};
            }

            r = nr;
            c = nc;
        }
    }
}