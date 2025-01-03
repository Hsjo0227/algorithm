import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
{
	static int[] p;
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	
    	int[][] adj = new int[N+1][N+1];
    	
    	// make set
    	p = new int[N+1];
    	for(int i = 0; i <= N; i++) {
    		p[i] = i;
    	}
    	
    	for(int i = 1; i <=N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			adj[i][j] = num;
    			
    			if(adj[j][i] != 1 && num == 1) union(i, j);
    		}
    	}
    	

    	st = new StringTokenizer(br.readLine());
    	
    	int from = Integer.parseInt(st.nextToken());
    	int to = 0;
    	
    	boolean answer = true;
    	
    	for(int i = 0; i < M-1; i++) {
    		to = Integer.parseInt(st.nextToken());
    		if(find(from) != find(to)) {
    			answer = false;
    			break;
    		}
    		from = to;
    	}
    	
    	System.out.println(answer? "YES": "NO");
    
    	
    }
    
    public static int find(int a) {
    	if(p[a] == a) return a;
    	else return find(p[a]);
    }
    
    public static void union(int a, int b) {
    	int parentA = find(a);
    	int parentB = find(b);
    	if(parentA == parentB) return;
    	p[parentA] = parentB;
    }
}
