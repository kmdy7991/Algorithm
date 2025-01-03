import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String n;
		while ((n = in.readLine()) != null) {
			cal(stoi.apply(n));
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static StringBuilder sb = new StringBuilder();

	private static void cal(int count) {
		int num = (int) Math.pow(3, count - 1);
		if (count == 0) {
			sb.append("-");
			return;
		}

		cal(count - 1);
		for (int i = 0; i < num; i++) {
			sb.append(" ");
		}
		cal(count - 1);

	}
}