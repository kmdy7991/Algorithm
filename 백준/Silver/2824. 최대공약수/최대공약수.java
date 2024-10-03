import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static final int MAX = (int) 1e9 + 1;
	static List<Integer> prime;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		prime = init();
		int n = stoi.apply(in.readLine());

		st = new StringTokenizer(in.readLine());

		Map<Integer, Integer> a = new HashMap<>();
		for (int i = 0; i < n; i++) {
			putValue(stoi.apply(st.nextToken()), a);
		}

		int m = stoi.apply(in.readLine());

		st = new StringTokenizer(in.readLine());

		Map<Integer, Integer> b = new HashMap<>();
		for (int i = 0; i < m; i++) {
			putValue(stoi.apply(st.nextToken()), b);
		}

		System.out.println(result(a, b));
	}

	private static String result(Map<Integer, Integer> a, Map<Integer, Integer> b) {
		long res = 1;
		boolean large = false;
		
		for (int num : a.keySet()) {
			if (b.containsKey(num)) {
				int min = Math.min(a.get(num), b.get(num));

				while (min-- > 0) {
					res *= num;

					if (res >= MAX - 1) {
						res %= MAX - 1;
						large = true;
					}
				}
			}
		}

		return large ? String.format("%09d", res) : res + "";
	}

	private static void putValue(int num, Map<Integer, Integer> map) {
		for (int p : prime) {
			if (num % p == 0) {
				map.put(p, map.getOrDefault(p, 0) + 1);
				putValue(num / p, map);
				return;
			}
		}

		if (num != 1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
	}

	private static List<Integer> init() {
		List<Integer> store = new ArrayList<>();
		boolean[] visited = new boolean[40000];
		for (int i = 2; i <= Math.sqrt(MAX) + 1; i++) {
			if (visited[i]) {
				continue;
			}

			store.add(i);
			for (int j = i << 1; j <= Math.sqrt(MAX) + 1; j += i) {
				visited[j] = true;
			}
		}

		return store;
	}
}