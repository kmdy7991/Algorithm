import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[] prime = init();

		int n = stoi.apply(in.readLine());
		int m = stoi.apply(in.readLine());

		List<Integer> store = new ArrayList<>();
		for (int i = n; i <= m; i++) {
			if (!prime[i]) {
				store.add(i);
			}
		}

		if (store.size() == 0) {
			System.out.println(-1);
			return;
		}

		int min = (int) 1e5;
		int sum = 0;
		
		for (int num : store) {
			min = Math.min(min, num);
			sum += num;
		}
		
		System.out.println(sum);
		System.out.print(min);
	}

	private static boolean[] init() {
		boolean[] prime = new boolean[10001];

		for (int i = 2; i <= Math.sqrt(10001) + 1; i++) {
			for (int j = i << 1; j < 10001; j += i) {
				prime[j] = true;
			}
		}
		prime[0]
				= prime[1] = true;
		return prime;
	}
}