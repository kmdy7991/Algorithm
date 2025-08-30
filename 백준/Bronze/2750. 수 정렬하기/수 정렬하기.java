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
		for (int i = 0; i < n; i++) {
			arr[i] = stoi.apply(in.readLine());
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(num).append("\n");
		}
		
		System.out.print(sb);
	}
}
