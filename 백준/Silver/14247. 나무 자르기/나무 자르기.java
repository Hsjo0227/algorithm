import java.io.*;
import java.util.*;

class Main {
    static class Tree implements Comparable<Tree>{
        int h;
        int a;
        
        public Tree(int h, int a) {
            this.h = h;
            this.a = a;
        }
        
        public int compareTo(Tree t) {
            return Integer.compare(this.a, t.a);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        Tree[] trees = new Tree[N];
        
        for(int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            
            trees[i] = new Tree(h, a);
        }
        
        Arrays.sort(trees);
        
        long answer = 0;
        for(int i = 0; i < N; i++) {
            Tree tree = trees[i];
            
            long num = tree.h + (long)tree.a * i;
            answer += num;
        }
        System.out.println(answer);
        
    }
}