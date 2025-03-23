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
			for (int i = 0; i < 10; i++) {

				sum += stoi.apply(st.nextToken());
			}

			sb.append("#").append(tc).append(" ").append(Math.round(sum / 10)).append("\n");
		}

		System.out.print(sb);
	}
}
