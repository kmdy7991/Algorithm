import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= n; tc++) {
			int sum = 0;

			String date = in.readLine();

			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6, 8));

			boolean flag = false;
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day > 0 && day < 32) {
					flag = true;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day > 0 && day < 31) {
					flag = true;
				}
				break;
			case 2:
				if (day > 0 && day < 29) {
					flag = true;
				}
				break;

			}
			
			if(flag) {
				store(tc, date, sb);
			} else {
				sb.append("#").append(tc).append(" ").append("-1").append("\n");
			}
		}

		System.out.print(sb);
	}

	private static void store(int tc, String date, StringBuilder sb) {
		sb.append("#").append(tc).append(" ").append(date.substring(0, 4)).append("/").append(date.substring(4, 6))
				.append("/").append(date.substring(6, 8)).append("\n");
	}
}
