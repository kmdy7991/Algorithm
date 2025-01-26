import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi.apply(in.readLine());

		List<Integer> store = new ArrayList<>();

		int cnt = 1;
		int num;
		while ((num = (cnt * (cnt + 1) * (cnt + 2)) / 6) <= n) {
			store.add(num);
			cnt++;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, (int) 1e9);

		for (int cannon : store) {
			dp[cannon] = 1;
			for (int i = cannon; i <= n; i++) {
				dp[i] = Math.min(dp[i], dp[i - cannon] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}