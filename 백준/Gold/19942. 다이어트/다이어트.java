import java.util.*;
import java.io.*;

public class Main { //백준 2638번 치즈

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        
        int[] minimum = new int[4]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	minimum[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<5; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        //end input
        
        List<Integer> ansList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int mask=1; mask<(1<<N); mask++) {
        	int[] ele = new int[5];
        	
        	List<Integer> pickedNum = new ArrayList<>();
        	//비트마스킹으로 부분집합
        	
        	for(int i=0; i<N; i++) {
        		if((mask&(1<<i)) !=0) {
        			pickedNum.add(i+1);
        			for(int j=0; j<5; j++) {
        				ele[j] += arr[i][j];
        			}
        		}
        	}
        	//요소들 최소 기준 확인
        	boolean flag = false;
        	for(int i=0; i<4; i++) {
        		if(minimum[i]>ele[i]) {
        			flag = true;
        			break; 
        		}
        	}
        	
        	if(!flag) {
        		if(ele[4]<min) {
        			min = ele[4];
        			ansList = pickedNum;
        		}
        		else if(ele[4]==min) {
        			if(compareList(ansList, pickedNum)) ansList = new ArrayList<>(pickedNum);
        		}
        	}
        }
        Collections.sort(ansList);
        if(min==Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(min);
        	for(int i : ansList) System.out.print(i+" ");
        }
    }//end main
    
    static public boolean compareList(List<Integer> ansList, List<Integer>pickedNum) {
    	int size = Math.min(ansList.size(), pickedNum.size());
    	for(int i=0; i<size; i++) {
    		if(ansList.get(i) > pickedNum.get(i)) {
    			return true;
    		}
    		else if(ansList.get(i)<pickedNum.get(i)) {
    			return false;
    		}
    	}
    	return pickedNum.size() < ansList.size();
    }
}