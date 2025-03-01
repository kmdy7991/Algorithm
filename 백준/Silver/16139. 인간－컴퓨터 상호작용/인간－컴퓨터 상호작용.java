import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static boolean flag = true;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String line = in.readLine();

		int[][] sumArr = new int[line.length() + 1][26];

		sumArr[0][line.charAt(0) - 'a']++;

		for (int i = 1; i < line.length(); i++) {
			for (int j = 0; j < 26; j++) {
				sumArr[i][j] = sumArr[i - 1][j];
			}
			sumArr[i][line.charAt(i) - 'a']++;
		}

		int q = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());

			char alpha = st.nextToken().charAt(0);

			int s = stoi.apply(st.nextToken());
			int e = stoi.apply(st.nextToken());

			if (s == 0) {
				sb.append(sumArr[e][alpha - 'a']).append("\n");
			} else {
				sb.append(sumArr[e][alpha - 'a'] - sumArr[s - 1][alpha - 'a']).append("\n");
			}
		}

		System.out.print(sb);
	}
}