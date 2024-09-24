import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[][], tempArr[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //end input

        int min = Integer.MAX_VALUE;
        for(int mask=1; mask<(1<<N)-1; mask++) {
            int A = 0;
            int B = 0;
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            for(int i=0; i<N; i++) {
                if((mask&(1<<i))!=0) {
                    listA.add(i);
                }
                else {
                    listB.add(i);
                }
            }
            int sumA = getScore(listA);
            int sumB = getScore(listB);
            min = Math.min(min,Math.abs(sumA-sumB));
        }
        System.out.println(min);
    }//end main

    public static int getScore(List<Integer> list) {
        int sum = 0;
        for(int i = 0; i< list.size(); i++) {
            for(int j = 0; j< list.size(); j++) {
                sum+=arr[list.get(i)][list.get(j)];
            }
        }
        return sum;
    }

}