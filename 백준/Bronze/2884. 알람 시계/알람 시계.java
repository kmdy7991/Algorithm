import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int h = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		if (m < 45) {
			h--;
		}

		if (h < 0) {
			h = (24 + h);
		}

		System.out.println(h + " " + (m >= 45 ? m - 45 : m + (60 - 45)));
	}
}