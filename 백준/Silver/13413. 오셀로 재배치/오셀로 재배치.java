import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = stoi.apply(in.readLine());
		while (t-- > 0) {
			int n = stoi.apply(in.readLine());

			String line = in.readLine();
			String origin = in.readLine();

			int black = 0;
			int white = 0;
			for (int i = 0; i < n; i++) {
				if (line.charAt(i) != origin.charAt(i)) {
					if (line.charAt(i) == 'B') {
						black++;
					} else {
						white++;
					}
				}
			}

			System.out.println(Math.max(black, white));
		}
	}
}