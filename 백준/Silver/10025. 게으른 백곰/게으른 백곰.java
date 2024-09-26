import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int k = stoi.apply(st.nextToken());

		int[] arr = new int[1000001];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			int ice = stoi.apply(st.nextToken());
			arr[stoi.apply(st.nextToken())] = ice;
		}

		int coverage = 1 + (k << 1);

		long sum = 0;
		long res = 0;
		for (int i = 0; i < 1000001; i++) {
			if (i >= coverage) {
				sum -= arr[i - coverage];
			}
			sum += arr[i];

			res = Math.max(sum, res);
		}
		System.out.println(res);
	}
}