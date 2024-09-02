import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int[] train;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		train = new int[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int order = stoi.apply(st.nextToken());
			int num = stoi.apply(st.nextToken());

			load(order, num - 1, st);
		}
		trainCount();
	}

	private static void trainCount() {
		Set<Integer> boarder = new HashSet<>();

		for (int num : train) {
			boarder.add(num);
		}

		System.out.println(boarder.size());
	}

	private static void load(int order, int num, StringTokenizer st) {
		int sit = 0;
		if (order < 3) {
			sit = stoi.apply(st.nextToken()) - 1;
		}

		switch (order) {
		case 1:
			train[num] |= (1 << sit);
			break;
		case 2:
			train[num] &= ~(1 << sit);
			break;
		case 3:
			train[num] = (train[num] << 1) & ~(1 << 20);
			break;
		case 4:
			train[num] = train[num] >> 1;

			break;

		}
	}
}