import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		boolean[] struct = new boolean[n];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			struct[i] = "1".equals(st.nextToken());
		}

		Deque<Integer> deque = new ArrayDeque<>();

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int num = stoi.apply(st.nextToken());

			if (!struct[i]) {
				deque.offerLast(num);
			}
		}
		int m = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++) {
			deque.offerFirst(stoi.apply(st.nextToken()));

			sb.append(deque.pollLast()).append(" ");
		}

		System.out.println(sb);
	}
}