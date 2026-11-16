class Solution {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();

        int[] pos = new int[2];
        boolean[][] board = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String str = park[i];
            for (int j = 0; j < W; j++) {
                char ch = str.charAt(j);

                switch (ch) {
                    case 'S':
                        pos[0] = i;
                        pos[1] = j;
                        break;
                    case 'X':
                        board[i][j] = true;
                        break;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            int dir = 0;
            int distance = Integer.parseInt(parts[1]);

            switch (parts[0]) {
                case "E":
                    dir = 0;
                    break;
                case "S":
                    dir = 1;
                    break;
                case "W":
                    dir = 2;
                    break;
                case "N":
                    dir = 3;
                    break;
            }

            int nr = pos[0];
            int nc = pos[1];
            boolean canMove = true;

            for (int step = 0; step < distance; step++) {
                nr += dr[dir];
                nc += dc[dir];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc]) {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                pos[0] = nr;
                pos[1] = nc;
            }
        }

        return pos;
    }
}