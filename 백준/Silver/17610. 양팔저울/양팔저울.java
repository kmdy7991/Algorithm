import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] arr = new int[n];

		st = new StringTokenizer(in.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(st.nextToken());

			max += arr[i];
		}

		check = new boolean[max + 1];
		findSum(0, 0, n, arr);

		int res = 0;
		for (int i = 1; i < max + 1; i++) {
			if (!check[i]) {
				res++;
			}
		}

		System.out.println(res);
	}

	private static void findSum(int cur, int sum, int n, int[] arr) {
		if (cur == n) {
			if (sum >= 0) {
				check[sum] = true;
			}
			return;
		}

		findSum(cur + 1, sum + arr[cur], n, arr);
		findSum(cur + 1, sum - arr[cur], n, arr);
		findSum(cur + 1, sum, n, arr);
	}
}