import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int a = stoi.apply(st.nextToken());
		int b = stoi.apply(st.nextToken());
		
		String result = "A";
		if((a + 2) % 3 != b) {
			result = "B";
		}
		
		System.out.println(result);
	}
}