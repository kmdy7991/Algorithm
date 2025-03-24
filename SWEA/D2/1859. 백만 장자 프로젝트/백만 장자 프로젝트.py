import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int t = stoi.apply(in.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = stoi.apply(in.readLine());

            int[] arr = new int[n];
            
            st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = stoi.apply(st.nextToken());
			}

			int max = -1;
			long sum = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (max < arr[i]) {
					max = arr[i];
				} else {
					sum += max - arr[i];
				}
			}

			sb.append(String.format("#%d %d\n", tc, sum));
		}

		System.out.println(sb);

	}
}