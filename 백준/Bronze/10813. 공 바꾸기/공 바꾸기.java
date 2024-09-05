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

			int start = stoi.apply(st.nextToken());
			int end = stoi.apply(st.nextToken());

			int temp = arr[start - 1];
			arr[start - 1] = arr[end - 1];
			arr[end - 1] = temp;

		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}