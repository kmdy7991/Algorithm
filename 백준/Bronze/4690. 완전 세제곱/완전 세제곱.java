import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		for (int a = 6; a < 101; a++) {
			for (int b = 2; b <= a; b++) {
				for (int c = b + 1; c <= a; c++) {
					for (int d = c + 1; d <= a; d++) {
						if (Math.pow(a, 3) == (Math.pow(b, 3) + Math.pow(c, 3) + Math.pow(d, 3))) {
							sb.append(String.format("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d));
						}
					}
				}
			}
		}

		System.out.println(sb);
	}
}