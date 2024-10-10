import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nLife = Integer.parseInt(st.nextToken());
		int nNode = Integer.parseInt(st.nextToken());
		int nVertex = Integer.parseInt(st.nextToken());

		List<Vertex>[] vertices = new List[nNode + 1];
		for (int i = 1; i <= nNode; i++) {
			vertices[i] = new ArrayList<>();
		}

		for (int v = 0; v < nVertex; v++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			vertices[src].add(new Vertex(des, time, cost));
			vertices[des].add(new Vertex(src, time, cost));
		}

		st = new StringTokenizer(br.readLine());
		int source = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());

		Queue<Boat> queue = new PriorityQueue<>();
		int[][] dp = new int[nNode + 1][nLife + 1];
		for (int i = 1; i <= nNode; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		queue.add(new Boat(source, 0, nLife));
		while (!queue.isEmpty()) {
			Boat cur = queue.poll();

			if(cur.des == destination) {
				System.out.println(cur.time);
				return;
			}
			if (cur.time >= dp[cur.des][cur.life])
				continue;
			for (int life = cur.life; life > 0; life--) {
				if (cur.time >= dp[cur.des][life])
					break;
				dp[cur.des][life] = cur.time;
			}

			for (Vertex next : vertices[cur.des]) {
				if (cur.life <= next.cost)
					continue;
				queue.add(new Boat(next.des, cur.time + next.time, cur.life - next.cost));
			}
		}
		
		System.out.println("-1");
	}
}

class Boat implements Comparable<Boat> {
	int des;
	int time;
	int life;

	Boat(int des, int time, int life) {
		this.des = des;
		this.time = time;
		this.life = life;
	}

	public int compareTo(Boat b) {
		if (this.time == b.time)
			return b.life - this.life;
		return this.time - b.time;
	}
}

class Vertex {
	int des;
	int time;
	int cost;

	Vertex(int des, int time, int cost) {
		this.des = des;
		this.time = time;
		this.cost = cost;
	}
}