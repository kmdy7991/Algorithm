import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int a = stoi.apply(st.nextToken());
		int b = stoi.apply(st.nextToken());
		int c = stoi.apply(st.nextToken());

		if (a == b && b == c) {
			System.out.println(10000 + a * 1000);
		} else if (a == b || b == c || a == c) {
			System.out.println(1000 + (a == b ? a : a == c ? c : b) * 100);
		} else {
			System.out.println(Math.max(a, Math.max(c, b)) * 100);
		}
	}
}