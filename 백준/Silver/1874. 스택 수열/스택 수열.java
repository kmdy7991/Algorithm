import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int n = stoi.apply(in.readLine());

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = stoi.apply(in.readLine());
		}

		int idx = 0;
		int count = 1;

		while (count <= n) {
			stack.offerLast(count);
			sb.append("+").append("\n");

			while (idx < n && !stack.isEmpty() && nums[idx] == stack.peekLast()) {
				stack.pollLast();
				sb.append("-").append("\n");
				idx++;
			}
			
			count++;
		}

		if (!stack.isEmpty()) {
			while (idx < n && stack.peekLast() == nums[idx]) {
				stack.pollLast();
				sb.append("-").append("\n");
				idx++;
			}
		}

		System.out.print(stack.isEmpty() ? sb : "NO");
	}
}
