import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String str = input + input;
		
		int aCount = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == 'a') aCount++;
		}
		
		int min = Integer.MAX_VALUE;
		int diff = 0;
		
		for(int i = 0; i < aCount; i++) {
			if(input.charAt(i) == 'b') diff++;
		}
		
		min = diff;
		
		for(int i = 0; i < input.length(); i++) {
			if(str.charAt(i) == 'b') diff--;
			if(str.charAt(i + aCount) == 'b') diff++;
			min = Integer.min(min, diff);
		}
		
		System.out.println(min);
	}
}
