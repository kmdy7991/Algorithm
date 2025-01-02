import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());
		long[] arr = new long[(int) 1e6 + 1];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i<= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
		}
		System.out.println(arr[n]);
	}
}