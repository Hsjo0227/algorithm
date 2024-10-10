import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nNode = Integer.parseInt(st.nextToken());
		int nVertex = Integer.parseInt(st.nextToken());

		Queue<Vertex> queue = new PriorityQueue<>();
		for (int vertex = 0; vertex < nVertex; vertex++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			queue.add(new Vertex(src, des, cost, time));
		}

		UnionFind uf = new UnionFind(nNode + 1);
		long cost = 0;
		int nSelectVertices = 0, time = 0;
		while (!queue.isEmpty() && nSelectVertices < nNode - 1) {
			Vertex cur = queue.poll();
			
			if(uf.isConnected(cur.src, cur.des))
				continue;
			uf.union(cur.src, cur.des);
			cost += cur.cost;
			time = Math.max(time, cur.time);
			nSelectVertices++;
		}

		if(nSelectVertices != nNode - 1)
			System.out.println("-1");
		else
			System.out.println(time + " " + cost);
	}
}

class UnionFind {
	int[] parent;
	int[] rank;

	UnionFind(int nNode) {
		parent = new int[nNode];
		rank = new int[nNode];

		for (int i = 0; i < nNode; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int node) {
		if (node != parent[node]) {
			parent[node] = find(parent[node]);
		}
		return parent[node];
	}

	public void union(int nodeA, int nodeB) {
		int rootA = find(nodeA);
		int rootB = find(nodeB);

		if (rootA == rootB)
			return;

		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else if (rank[rootA] < rank[rootB]) {
			parent[rootA] = rootB;
		} else {
			parent[rootB] = rootA;
			rank[rootA] += rank[rootB];
		}
	}

	public boolean isConnected(int nodeA, int nodeB) {
		return find(nodeA) == find(nodeB);
	}
}

class Vertex implements Comparable<Vertex> {
	int src;
	int des;
	int cost;
	int time;

	public Vertex(int src, int des, int cost, int time) {
		this.src = src;
		this.des = des;
		this.cost = cost;
		this.time = time;
	}

	public int compareTo(Vertex v) {
		if(this.cost == v.cost)
			return this.time - v.time;
		return this.cost - v.cost;
	}
}