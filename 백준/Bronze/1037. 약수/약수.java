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
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = stoi.apply(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.print(arr[0] * arr[n - 1]);
	}
}