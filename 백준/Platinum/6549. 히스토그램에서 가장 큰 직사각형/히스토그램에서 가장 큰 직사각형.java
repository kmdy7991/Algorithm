import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(in.readLine());
			
			int n = stoi.apply(st.nextToken());
			
			if (n == 0) {
				break;
			}
			
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = stoi.apply(st.nextToken());
			}

			System.out.println(extent(n, nums));
		}
	}

	private static long extent(int n, int[] nums) {
		long res = -1L;

		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {

			while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
				long height =  nums[stack.pollLast()];
				int width = stack.isEmpty() ? i : i - 1 - stack.peekLast();

				res = Math.max(res, height * width);
			}

			stack.offerLast(i);
		}

		while (!stack.isEmpty()) {
			long height = nums[stack.pollLast()];
			int width = stack.isEmpty() ? n : n - 1 - stack.peekLast();

			res = Math.max(res, height * width);
		}
		return res;
	}
}