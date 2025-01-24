import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi.apply(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = i;
			arr[i][1] = stoi.apply(st.nextToken());
		}

		Arrays.sort(arr, Comparator.comparing(x -> x[1]));
		for (int i = 0; i < n; i++) {
			arr[i][1] = i;
		}

		Arrays.sort(arr, Comparator.comparing(x -> x[0]));
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			if (Math.abs(arr[i][1] - arr[i + 1][1]) > 1) {
				res++;
			}
		}
        
		System.out.println(res);
	}
}