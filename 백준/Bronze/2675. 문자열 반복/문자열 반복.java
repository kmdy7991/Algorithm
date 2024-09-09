import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			st = new StringTokenizer(in.readLine());

			int n = stoi.apply(st.nextToken());
			String word = st.nextToken();

			sb.append(wordRepeat(n, word)).append("\n");
		}
		System.out.print(sb);
	}

	private static Object wordRepeat(int n, String word) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < n; j++) {
				sb.append(word.charAt(i));
			}
		}
		return sb.toString();
	}
}