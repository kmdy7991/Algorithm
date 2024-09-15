import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int cur = 1;
		while (n > cur) {
			n -= cur;
			cur++;
		}

		if (cur % 2 == 1) {
			System.out.println((cur + 1 - n) + "/" + n);
		} else {
			System.out.println(n + "/" + (cur + 1 - n));
		}
	}
}