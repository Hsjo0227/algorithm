import java.util.*;

class Solution {
    public int solution(int[][] visible, int[][] hidden, int k) {
        int answer = Integer.MIN_VALUE;
        
        int n = visible.length;
        int m = visible[0].length;
        
        int[] normal = new int[m];
        int[] flipped = new int[m];
        int[] bestColumn = new int[m];
        
        for(int mask = 0; mask < (1 << n); mask++) {
            Arrays.fill(normal, 0);
            Arrays.fill(flipped, 0);
            
            for(int i = 0; i < n; i++) {
                boolean rowFlipped = (mask & (1 << i)) != 0;
                
                for(int j = 0; j < m; j++) {
                    if(rowFlipped) {
                        normal[j] += hidden[i][j];
                        flipped[j] += visible[i][j];
                    } else {
                        normal[j] += visible[i][j];
                        flipped[j] += hidden[i][j];
                    }
                }
            }
            
            int total = -k * Integer.bitCount(mask);
            
            for(int j = 0; j < m; j++) {
                bestColumn[j] = Math.max(normal[j], flipped[j] - k);
                total += bestColumn[j];
            }
            
            if(n % 2 != 0 || m % 2 != 0) {
                answer = Math.max(answer, total);
                continue;
            }
            
            for(int i = 0; i < n; i++) {
                boolean rowFlipped = (mask & (1 << i)) != 0;
                
                for(int j = 0; j < m; j++) {
                    if((i+j) % 2 == 0) continue;
                    
                    int normalValue = rowFlipped ? hidden[i][j] : visible[i][j];
                    
                    int flippedValue = rowFlipped ? visible[i][j] : hidden[i][j];
                    
                    int columnWithoutCell = Math.max(
                        normal[j] - normalValue,
                        flipped[j] - flippedValue - k
                    );
                    
                    int score = total - bestColumn[j] + columnWithoutCell;
                    
                    answer = Math.max(answer, score);
                }
                
                
            }
        }
        
        return answer;
    }
}