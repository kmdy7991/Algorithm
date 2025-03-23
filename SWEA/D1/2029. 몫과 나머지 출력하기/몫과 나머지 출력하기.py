import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();


		int t = stoi.apply(in.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int n = stoi.apply(st.nextToken());
			int m = stoi.apply(st.nextToken());
			

			sb.append(String.format("#%d %d %d\n", tc, n / m, n % m));
		}

		System.out.print(sb);
	}
}