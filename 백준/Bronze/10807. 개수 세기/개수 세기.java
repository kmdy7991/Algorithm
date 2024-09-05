import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] nums = new int[201];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int num = stoi.apply(st.nextToken());
			if(num < 0) {
				num = -num + 100;
			}
			nums[num]++;
		}

		int find = stoi.apply(in.readLine());
		System.out.println(nums[find < 0 ? -find + 100 : find]);
	}
}