import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(in.readLine());
		}

		System.out.println(square(n, arr));
	}

	private static int square(int n, int[] nums) {
		Deque<Integer> dq = new ArrayDeque<>();

		int res = 0;
		for (int i = 0; i < n; i++) {

			while (!dq.isEmpty() && nums[dq.peekLast()] > nums[i]) {
				int height = nums[dq.pollLast()];
				int width = dq.isEmpty() ? i : i - 1 - dq.peekLast();

				res = Math.max(res, height * width);
			}

			dq.offerLast(i);
		}

		while (!dq.isEmpty()) {
			int height = nums[dq.pollLast()];
			int width = dq.isEmpty() ? n : n - 1 - dq.peekLast();

			res = Math.max(res, height * width);
		}

		return res;
	}
}