import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[1000001];
		int n = stoi.apply(in.readLine());

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int arrow = stoi.apply(st.nextToken());

			if (arr[arrow] != 0) {
				arr[arrow]--;
			}
			arr[arrow - 1]++;
		}

		int res = 0;
		for (int i : arr) {
			res += i;
		}

		System.out.println(res);
	}
}
