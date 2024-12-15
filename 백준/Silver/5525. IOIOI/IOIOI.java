import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		int m = stoi.apply(in.readLine());

		char[] io = in.readLine().toCharArray();

		int res = 0;
		for (int i = 0; i < m; i++) {
			if (io[i] == 'O') {
				continue;
			}
			int cnt = 0;
			while (i + 2 < m && io[i + 1] == 'O' && io[i + 2] == 'I') {
				cnt++;

				if (cnt == n) {
					res++;
					cnt--;
				}

				i += 2;
			}
		}
		System.out.println(res);
	}
}
