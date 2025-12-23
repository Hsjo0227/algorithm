import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        if(str.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            int need = -1;
            
            switch(ch) {
                case 'q': 
                    need = 0;
                    break;
                case 'u': 
                    need = 1;
                    break;
                case 'a': 
                    need = 2;
                    break;
                case 'c': 
                    need = 3;
                    break;
                case 'k': 
                    need = 4;
                    break;
            }
            
            boolean flag = false;
            
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == need) {
                    list.set(j, (need + 1) % 5);
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                if(ch == 'q') {
                    list.add(1);
                    max = Math.max(max, list.size());
                } else {
                    System.out.println(-1);
                    return;
                }
            }
            
        }
        
        for(int num : list) {
            if(num != 0) {
                System.out.println(-1);
                return;
            }
        }
        
        if(max == 0) max = -1;
        
        System.out.println(max);
    }
}