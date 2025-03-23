import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}

		System.out.print(sum);
	}
}
