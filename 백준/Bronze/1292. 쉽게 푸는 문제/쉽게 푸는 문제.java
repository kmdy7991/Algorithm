import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] arr = init();
		
		for(int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		System.out.println(arr[m] - arr[n - 1]);
	}

	private static int[] init() {
		int idx = 0;

		int[] arr = new int[1001];
		for (int i = 1; i < 300; i++) {
			for (int j = idx + 1; j <= i + idx; j++) {
				arr[j] = i;
				
				if (j >= 1000) {
					return arr;
				}
			}
			idx += i;
		}

		return arr;
	}
}