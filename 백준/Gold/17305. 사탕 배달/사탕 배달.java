import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static final char NULL = '\u0000';

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		List<Integer> three = new ArrayList<>();
		List<Integer> five = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			int num = stoi.apply(st.nextToken());
			int weight = stoi.apply(st.nextToken());

			if (num == 3) {
				three.add(weight);
			} else {
				five.add(weight);
			}
		}

		Collections.sort(three);
		Collections.sort(five);

		long[] third = new long[three.size() + 1];
		long[] fifth = new long[five.size() + 1];
		
		for (int i = three.size() - 1; i >= 0; i--) {
			third[three.size() - i] = third[three.size() - 1 - i] + three.get(i);
		}
		
		for (int i = five.size() - 1; i >= 0; i--) {
			fifth[five.size() - i] = fifth[five.size() - 1 - i] + five.get(i);
		}
		
		int cnt = Math.min(three.size(), m / 3);
		
		long res = third[cnt];
		while(cnt >= 0) {
			int fiveIdx = Math.min(five.size(), (m - (3 * cnt)) / 5);
			res = Math.max(res, third[cnt--] + fifth[fiveIdx]);
		}
		
		System.out.println(res);
	}
}