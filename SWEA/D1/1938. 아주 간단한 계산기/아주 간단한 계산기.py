import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());
		
		System.out.println(n + m);
		System.out.println(n - m);
		System.out.println(n * m);
		System.out.println(n / m);
	}
}
