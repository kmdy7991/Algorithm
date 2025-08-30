import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int c = stoi.apply(st.nextToken());

		Map<String, int[]> map = new HashMap<>();

		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < n; i++) {
			String num = st.nextToken();
			if (map.containsKey(num)) {
				int[] value = map.get(num);
				value[1]++;
			} else {
				map.put(num, new int[] { i, 1 });
			}
		}

		StringBuilder sb = new StringBuilder();

		map.entrySet().stream()
            .sorted(Comparator.<Map.Entry<String, int[]>>comparingInt(e -> e.getValue()[1]).reversed()
                    .thenComparingInt(e -> e.getValue()[0])
            )
            .forEach(entry -> {
					String key = entry.getKey();
					int count = entry.getValue()[1];
					for (int i = 0; i < count; i++) {
						sb.append(key).append(" ");
					}
				});

		System.out.print(sb);
	}
}
