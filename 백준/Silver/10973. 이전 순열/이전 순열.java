import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(st.nextToken());
		}

		System.out.print(find(arr, n));
	}

	private static String find(int[] arr, int n) {
		int cur = n - 1;

		while (cur > 0 && arr[cur - 1] <= arr[cur]) {
			cur--;
		}

        if (cur == 0) {
			return "-1";
		}

		int next = n - 1;
		while (arr[cur - 1] <= arr[next]) {
			next--;
		}

		swap(arr, cur - 1, next);

		int r = n - 1;
		while (cur < r) {
			swap(arr, cur, r);
			cur++;
			r--;
		}

		StringBuilder sb = new StringBuilder();

        for (int num : arr) {
			sb.append(num + " ");
		}
		
        return sb.toString();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}