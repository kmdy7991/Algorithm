import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] arr = new int[n + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + stoi.apply(st.nextToken());
		}

		int m = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			sb.append(findSum(stoi.apply(st.nextToken()), stoi.apply(st.nextToken()), arr)).append("\n");
		}
		
		System.out.print(sb);
	}

	private static int findSum(int s, int e, int[] arr) {
		return arr[e] - arr[s - 1];
	}
}
