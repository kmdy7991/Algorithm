import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[][] memo = new int[n + 1][n + 1];

		memo[2][1] = 2;

        for (int i = 3; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				memo[i][j] = (2 * memo[i - 1][j] + memo[i - 1][j - 1] + memo[i - 1][j + 1]) % 10007;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum = (sum + memo[n][i]) % 10007;
		}

		System.out.println(sum);
	}
}