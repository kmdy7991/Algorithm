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

		int height = m - n;

		if (height <= 3) {
			System.out.println(height);
			return;
		}

		double root = Math.sqrt(height);

		if (root == (int) root) {
			System.out.println(((int) root << 1) - 1);
		} else {
			if (height -  Math.pow((int) root, 2) <= (int) root) {
				System.out.println(((int) root << 1));
			} else {
				System.out.println(((int)root << 1) + 1);
			}
		}
	}
}