import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int t = stoi.apply(in.readLine());

		int n = 1;
		for (int tc = 0; tc <= t; tc++) {
			sb.append(n).append(" ");
			n <<= 1;
		}
		
		System.out.print(sb);
	}
}
