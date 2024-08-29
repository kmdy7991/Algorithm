import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi.apply(in.readLine());

		long[] arr = new long[36];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 5;

		if (n < 4) {
			System.out.println(arr[n]);
			return;
		}

		int cnt = 4;

		while (cnt <= n) {
			int s = 0;
			int e = cnt - 1;
			long sum = 0;
			
			while (e >= 0) {
				sum += arr[s++] * arr[e--];
			}

			arr[cnt++] = sum;
		}

		System.out.println(arr[n]);
	}
}