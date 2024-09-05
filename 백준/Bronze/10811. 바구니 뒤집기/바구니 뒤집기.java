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
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int s = stoi.apply(st.nextToken()) - 1;
			int e = stoi.apply(st.nextToken()) - 1;

			while (s <= e) {
				int temp = arr[s];
				arr[s++] = arr[e];
				arr[e--] = temp;

			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}