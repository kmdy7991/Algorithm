import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(in.readLine());
			int n = stoi.apply(st.nextToken());
			int m = stoi.apply(st.nextToken());

			sb.append(pair(n, m)).append("\n");
		}
		System.out.print(sb);
	}

	private static int pair(int n, int m) {
		int cnt = 0;

        for (int i = 1; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (((i * i + j * j + m) / (double) (i * j)) % 1 == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}