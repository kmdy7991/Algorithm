import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] coins = { 25, 10, 5, 1 };

		int t = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int num = stoi.apply(in.readLine());

			for (int coin : coins) {
				sb.append(num / coin).append(" ");
				num %= coin;
			}
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
}