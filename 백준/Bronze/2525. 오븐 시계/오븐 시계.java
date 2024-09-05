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

		int c = stoi.apply(in.readLine());

		h += (c / 60);
		m += (c % 60);

		if (m >= 60) {
			m %= 60;
			h++;
		}

		System.out.println((h % 24) + " " + m);
	}
}