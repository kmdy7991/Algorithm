import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= n; tc++) {
			double sum = 0;

			st = new StringTokenizer(in.readLine());

			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			char equal = '=';
			if (l > r) {
				equal = '>';
			}

			if (r > l) {
				equal = '<';
			}

			sb.append("#").append(tc).append(" ").append(equal).append("\n");
		}

		System.out.print(sb);
	}
}
