import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] chess = { 1, 1, 2, 2, 2, 8 };

		st = new StringTokenizer(in.readLine());

		StringBuilder sb = new StringBuilder();
		for (int c : chess) {
			sb.append(c - stoi.apply(st.nextToken())).append(" ");
		}
		
		System.out.println(sb);
	}
}