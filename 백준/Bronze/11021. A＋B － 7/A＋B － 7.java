import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int n = stoi.apply(in.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			sb.append(String.format("Case #%d: %d\n", i + 1, stoi.apply(st.nextToken()) + stoi.apply(st.nextToken())));
		}

		System.out.print(sb);
	}
}