import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		String target = in.readLine();

		int res = 0;
		for (int i = 0; i < n; i++) {
			res += available(target, in.readLine());
		}

		System.out.println(res);

	}

	private static int available(String target, String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == target.charAt(0)) {

				for (int j = i + 1; j < word.length(); j++) {
					if (word.charAt(j) == target.charAt(target.length() - 1)) {

						if ((j - i) % (target.length() - 1) == 0) {
							int space = (j - i) / (target.length() - 1);

							int cnt = 1;
							while (cnt < target.length()) {
								if (word.charAt(i + space * cnt) == target.charAt(cnt)) {
									cnt++;
								} else {
									break;
								}
							}

							if (cnt == target.length()) {
								return 1;
							}
						}
					}
				}
			}
		}
		return 0;
	}
}