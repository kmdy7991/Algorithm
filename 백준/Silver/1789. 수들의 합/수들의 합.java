import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long n = Long.parseLong(in.readLine());

		long sum = 0;
		long res = 0;
		for (int i = 1; i <= (int) 1e8; i++) {
			sum += i;
			if (sum > n) {
				res = i-1;
				break;
			}
		}
		System.out.println(res);
	}
}
