import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		Queue<Integer> q = new ArrayDeque<>();

		st = new StringTokenizer(in.readLine());

		int[] cnt = new int[10];

		int num = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int cur = stoi.apply(st.nextToken());
			q.offer(cur);

			if (cnt[cur]++ == 0) {
				num++;
			}

			while (num > 2) {
				int prev = q.poll();

				if (--cnt[prev] == 0) {
					num--;
				}
			}

			res = Math.max(res, q.size());
		}

		System.out.println(res);
	}
}