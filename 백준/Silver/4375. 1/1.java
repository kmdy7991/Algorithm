import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String num;

		while ((num = in.readLine()) != null) {

			int n = Integer.parseInt(num);

			int one = 1;
			int cnt = 1;

			while (one % n != 0) {

				one = (one * 10) % n + 1 % n;

				cnt++;
			}
			sb.append(cnt).append("\n");

		}

		System.out.print(sb);
	}
}