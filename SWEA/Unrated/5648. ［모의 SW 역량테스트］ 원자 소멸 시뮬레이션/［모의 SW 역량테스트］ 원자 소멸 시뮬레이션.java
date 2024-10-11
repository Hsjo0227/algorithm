import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    static final int[] dr = {1, -1, 0, 0}; // 아래, 위, 왼쪽, 오른쪽
    static final int[] dc = {0, 0, -1, 1};
    
    static class Atom {
        int r;
        int c;
        int dir;
        int pow;
        boolean alive;
        
        public Atom(int r, int c, int dir, int pow) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.pow = pow;
            this.alive = true;
        }
    }
    
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            answer = 0;
            
            Atom[] atoms = new Atom[N];
            HashMap<Integer, Integer> positionMap = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int r = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int dir = Integer.parseInt(st.nextToken());
                int pow = Integer.parseInt(st.nextToken());

                atoms[i] = new Atom(r, c, dir, pow);
            }
            
            for (int time = 0; time < 4000; time++) {
                positionMap.clear();
                
                for (int j = 0; j < N; j++) {
                    Atom atom = atoms[j];
                    if (!atom.alive) continue;
                    
                    int nr = atom.r + dr[atom.dir];
                    int nc = atom.c + dc[atom.dir];
                    
                    if (nr < 0 || nr >= 4001 || nc < 0 || nc >= 4001) {
                        atom.alive = false;
                        continue;
                    }
                    
                    atom.r = nr;
                    atom.c = nc;
                    
                    int pos = nr * 4000 + nc;
                    positionMap.put(pos, positionMap.getOrDefault(pos, 0) + 1);
                }
                
                for (int j = 0; j < N; j++) {
                    Atom atom = atoms[j];
                    if (!atom.alive) continue;
                    
                    int pos = atom.r * 4000 + atom.c;
                    if (positionMap.get(pos) > 1) {
                        atom.alive = false;
                        answer += atom.pow;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
