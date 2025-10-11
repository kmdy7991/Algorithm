import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st;

		for (int i = 0; i < 10 * n; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}

		List<Integer> result = 
            map.entrySet()
                .stream()
                .filter(v -> v.getValue() > 2 * n)
                .sorted((m1, m2) -> m1.getKey())
				.map(t -> t.getKey())
                .collect(Collectors.toList());

		System.out.print(
            result.isEmpty() ? 
            -1 : 
            result.stream().map(String::valueOf).collect(Collectors.joining(" "))
        );
	}
}

