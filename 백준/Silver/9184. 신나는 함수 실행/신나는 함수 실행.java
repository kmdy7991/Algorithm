import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int[][][] memo = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(in.readLine());

			int a = stoi.apply(st.nextToken());
			int b = stoi.apply(st.nextToken());
			int c = stoi.apply(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			System.out.println(String.format("w(%d, %d, %d) = %d", a, b, c, sum(a, b, c)));
		}

	}

	private static int sum(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}


		if (a > 20 || b > 20 || c > 20) {
			return memo[20][20][20] = sum(20, 20, 20);
		}

		if (memo[a][b][c] != 0) {

			return memo[a][b][c];
		}
		if (a < b && b < c) {
			return memo[a][b][c] = sum(a, b, c - 1) + sum(a, b - 1, c - 1) - sum(a, b - 1, c);
		}

		return memo[a][b][c] = sum(a - 1, b, c) + sum(a - 1, b - 1, c) + sum(a - 1, b, c - 1)
				- sum(a - 1, b - 1, c - 1);
	}
}
