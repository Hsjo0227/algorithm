import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long answer;
	static int[][] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Long.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1, 0, i);
			visited[i] = false;
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int city, int cnt, long length, int start) {
		if(cnt == N) {
			if(adj[city][start] != 0) {
				long total = length+adj[city][start];
				answer = Math.min(answer, total);
			}
			return;
		}
		
		if(length > answer) return;
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && adj[city][i] != 0) {
				visited[i] = true;
				dfs(i, cnt+1, length + adj[city][i], start);
				visited[i] = false;
			}
		}
	}
}
