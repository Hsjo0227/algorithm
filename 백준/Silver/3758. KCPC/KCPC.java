import java.io.*;
import java.util.*;

public class Main {
    static class Team implements Comparable<Team> {
        int id;
        int scoreSum;
        int[] scores;
        int submitCount;
        int lastSubmit;
        
        public Team(int id, int problemSize) {
            this.id = id;
            this.scoreSum = 0;
            this.scores = new int[problemSize+1];
            this.submitCount = 0;
            this.lastSubmit = 0;
        }

		@Override
		public int compareTo(Team o) {
			if(this.scoreSum != o.scoreSum) return -Integer.compare(this.scoreSum, o.scoreSum);
			if(this.submitCount != o.submitCount) return Integer.compare(this.submitCount, o.submitCount);
			return Integer.compare(this.lastSubmit, o.lastSubmit);
		}
		
		public void submit(int pId, int score, int time) {
			this.submitCount++;
			this.lastSubmit = time;
			if(this.scores[pId] < score) {
				this.scoreSum += score - this.scores[pId];
				this.scores[pId] = score;
			}
		}
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for(int i = 0; i < n; i++) {
            	teams[i] = new Team(i+1, k);
            }
            
            for(int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                
                teams[id-1].submit(problem, score, i);
            }
            
            Arrays.sort(teams);
            
            int answer = 0;
            for(int i = 0; i < n; i++) {
            	if(teams[i].id == t) {
            		answer = i+1;
            		break;
            	}
            }
            System.out.println(answer);
            
        }
    }
}