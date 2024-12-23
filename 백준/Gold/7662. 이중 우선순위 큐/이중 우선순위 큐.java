import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			int n = stoi.apply(in.readLine());

			SortedMap<Integer, Integer> sortMap = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());

				String order = st.nextToken();
				int num = stoi.apply(st.nextToken());

				if ("D".equals(order)) {
					if (sortMap.isEmpty()) {
						continue;
					}

					int remove = 0;
					if (num == -1) {
						remove = sortMap.firstKey();

						if (sortMap.get(remove) > 1) {
							sortMap.computeIfPresent(remove, (k, v) -> v - 1);
						} else {
							sortMap.remove(remove);
						}
					} else {
						remove = sortMap.lastKey();

						if (sortMap.get(remove) > 1) {
							sortMap.computeIfPresent(remove, (k, v) -> v - 1);
						} else {
							sortMap.remove(remove);

						}
					}
					continue;
				}
				sortMap.put(num, sortMap.getOrDefault(num, 0) + 1);
			}

			sb.append(sortMap.isEmpty() ? "EMPTY" : sortMap.lastKey() + " " + sortMap.firstKey()).append("\n");
		}
		System.out.print(sb);
	}
}
