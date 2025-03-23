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
			if(t % tc == 0) {
				sb.append(tc).append(" ");
			}
		}
		System.out.println(sb);
	}
}