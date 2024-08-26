import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] arr = new int[n];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(st.nextToken());
		}

		int cnt = 2;
		int len = 2;
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] <= arr[i + 1] && arr[i + 1] <= arr[i + 2]) {
				cnt = 2;
			} else if (arr[i] >= arr[i + 1] && arr[i + 1] >= arr[i + 2]) {
				cnt = 2;
			} else {
				cnt++;
			}
			len = Math.max(cnt, len);
		}
		System.out.println(len);
	}
}