import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		StringBuilder sb = new StringBuilder();
        
		String line = in.readLine();
		
		for(char c : line.toCharArray()) {
			sb.append((c - 64)).append(" ");
		}
        
		System.out.print(sb);
	}
}
