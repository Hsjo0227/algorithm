import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      String[] words = new String[N];
      
      for(int i = 0; i < N; i++) {
          words[i] = br.readLine();
      }
      
      // Arrays.sort(words);
      int answer = 0;
      // 정답 위치치
      int idx1 = 0;
      int idx2 = 0;
      
      for(int i = 0; i < N; i++) {
          for(int j = i+1; j < N; j++) {
              String word1 = words[i];
              String word2 = words[j];
              // 같은 글자면 넘어가기
              if(word1.equals(word2)) break;
              
              int length = Math.min(word1.length(), word2.length());
              
              int match = 0;
              for(int k = 0; k < length; k++) {
                  if(word1.charAt(k) != word2.charAt(k)) break;
                  match++;
              }
              
              if(match > answer) {
                  idx1 = i;
                  idx2 = j;
                  answer = match;
              }
              
              
          }
      }
      
      System.out.println(words[idx1]);
      System.out.println(words[idx2]);
  }
}