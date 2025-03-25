import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		long[] nums = init();

		int tc = stoi.apply(in.readLine());
		for (int t = 0; t < tc; t++) {

			int n = stoi.apply(in.readLine());

			sb.append(nums[n]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long[] init() {
		int[] arr = new int[(int) 1e6 + 1];
		Arrays.fill(arr, 1);

		for (int i = 2; i < arr.length; i++) {
			for (int j = 1; i * j < arr.length; j++) {
				arr[i * j] += i;
			}
		}

		long[] sum = new long[(int) 1e6 + 1];

		for (int i = 1; i < (int) 1e6 + 1; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		
		return sum;
	}
}
