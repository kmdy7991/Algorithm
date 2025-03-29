import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		int m = stoi.apply(in.readLine());

		boolean[] button = new boolean[10];

		if (m > 0) {
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < m; i++) {
				button[stoi.apply(st.nextToken())] = true;
			}
		}

		res = Math.abs(n - 100);

		for (int i = 0;; i++) {

			if (i - n > res) {
				break;
			}

			find(i, n, button);
		}

		System.out.print(res);
	}

	private static void find(int cur, int num, boolean[] button) {
		int length = 0;
		int next = cur;
		
		do {
			length++;
			if (button[next % 10]) {
				return;
			}
			next /= 10;

		} while (next != 0);

        if (length + Math.abs(num - cur) < res)
            res = length + Math.abs(num - cur);
	}
}