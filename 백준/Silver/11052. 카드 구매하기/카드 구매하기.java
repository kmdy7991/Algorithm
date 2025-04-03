import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] arr = new int[n + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = stoi.apply(st.nextToken());
		}

		int[] memo = new int[n + 1];
		memo[1] = arr[1];
        
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				memo[i] = Math.max(memo[i], memo[i - j] + arr[j]);
			}
		}
		
		System.out.println(memo[n]);
	}
}