import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static Map<Long, Integer> heart;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		heart = new HashMap<>();
        
		int res = findHeart(n, m);
        
		if(heart.getOrDefault(m, 0) == 1 || res == 1) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}

	private static int findHeart(long n, long m) {
		if(heart.containsKey(n)) {
			return heart.get(n);
		}

		if (n < m) {
			return 0;
		}
		
		if (n == m) {
			return 1;
		}


		if (n % 2 == 0) {
			heart.put(n >> 1, findHeart(n >> 1, m));
		} else {
			heart.put((n - 1) >> 1, findHeart((n - 1) >> 1, m));
			heart.put(((n - 1) >> 1) + 1, findHeart(((n - 1) >> 1) + 1, m));
		}
		return heart.getOrDefault(n, 0);
	}
}