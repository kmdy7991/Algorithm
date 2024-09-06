import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		for(int i = n; i > 0; i--) {
			for(int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}