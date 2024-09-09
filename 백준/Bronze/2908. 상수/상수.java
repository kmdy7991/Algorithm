import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		sb.append(in.readLine());
		
		sb.reverse();
		
		System.out.print(max(sb.toString().split(" ")));
	}

	private static int max(String[] nums) {
		return Math.max(stoi.apply(nums[0]), stoi.apply(nums[1]));
	}
}