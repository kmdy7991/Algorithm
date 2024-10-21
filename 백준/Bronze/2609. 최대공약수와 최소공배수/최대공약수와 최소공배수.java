import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int max = gcd(n, m);

		System.out.print(String.format("%d\n%d", max, n * m / max));
	}

	private static int gcd(int n, int m) {
		if (m == 0) {
			return n;
		}

		return gcd(m, n % m);
	}
}