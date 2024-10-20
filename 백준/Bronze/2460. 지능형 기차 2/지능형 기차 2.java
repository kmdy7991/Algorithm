import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int cnt = 0;
		int res = 0;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(in.readLine());

			int out = stoi.apply(st.nextToken());
			int get = stoi.apply(st.nextToken());

			cnt -= out;
			cnt += get;
			res = Math.max(res, cnt);
		}

		System.out.print(res);
	}
}