import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[26];

		Arrays.fill(arr, -1);

		String word = in.readLine();

		for (int i = 0; i < word.length(); i++) {
			if (arr[word.charAt(i) - 'a'] == -1) {
				arr[word.charAt(i) - 'a'] = i;
			}
		}

		for (int n : arr) {
			System.out.print(n + " ");
		}
	}
}