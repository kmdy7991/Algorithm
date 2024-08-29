import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int n, m, res;
	static List<int[]> chicken;
	static List<int[]> houses;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = stoi.apply(st.nextToken());
		m = stoi.apply(st.nextToken());

		houses = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < n; j++) {
				int num = stoi.apply(st.nextToken());

				if (num == 1) {
					houses.add(new int[] { i + 1, j + 1 });
				} else if (num == 2) {
					chicken.add(new int[] { i + 1, j + 1 });
				}
			}
		}

		res = (int) 2e9;
		findDistance(0, 0, new int[m]);
		System.out.println(res);
	}

	private static void findDistance(int idx, int cnt, int[] store) {
		if (cnt == m) {
			res = Math.min(minPath(store), res);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			store[cnt] = i;
			findDistance(i + 1, cnt + 1, store);
		}
	}

	private static int minPath(int[] store) {
		int min = 0;

		for (int[] house : houses) {
			int sum = (int) 2e9;
			
			for (int idx : store) {
				sum = Math.min(sum, path(house, chicken.get(idx)));
			}

			min += sum;
		}
		return min;
	}

	private static int path(int[] h, int[] c) {
		return Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	}
}