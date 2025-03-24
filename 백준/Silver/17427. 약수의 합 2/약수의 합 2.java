import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int n = stoi.apply(in.readLine());
		
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += (n / i) * i;
		}
		
		System.out.print(sum);
	}
}