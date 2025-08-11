import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int sum = 0;
		int[] nums = new int[3];
		for (int i = 0; i < 3; i++) {
			sum += (nums[i] = stoi.apply(st.nextToken()));
		}
        
		Arrays.sort(nums);

		if (nums[2] >= (nums[1] + nums[0])) {
			sum -= nums[2] - (nums[1] + nums[0] - 1);
		}

		System.out.print(sum);
	}
}