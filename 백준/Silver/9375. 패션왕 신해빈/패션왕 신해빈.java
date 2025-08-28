import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

		Map<String, Integer> clothes = new HashMap<>();

		while (t-- > 0) {
			int n = stoi.apply(in.readLine());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());

				st.nextToken();
				String type = st.nextToken();

				clothes.put(type, clothes.getOrDefault(type, 0) + 1);
			}
			
			System.out.println(clothes.values().stream().reduce(1, (total, i) -> total * (i + 1)) - 1);
			
			clothes.clear();
		}
	}
}