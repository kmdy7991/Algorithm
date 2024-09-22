import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long[][] memo = new long[31][31];
		Arrays.fill(memo[0], 1L);

		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (j == 0) {
					memo[i][j] = memo[i - 1][j + 1];
				} else {
					memo[i][j] = memo[i - 1][j + 1] + memo[i][j - 1];
				}
			}
		}

		int num = -1;
		while ((num = stoi.apply(in.readLine())) != 0) {
			System.out.println(memo[num][0]);
		}
	}
}