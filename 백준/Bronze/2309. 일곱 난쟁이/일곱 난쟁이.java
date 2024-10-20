import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = stoi.apply(in.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr);

		check: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					arr[i] = arr[j] = -1;
					break check;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i] != -1) {
				System.out.println(arr[i]);
			}
		}
	}
}