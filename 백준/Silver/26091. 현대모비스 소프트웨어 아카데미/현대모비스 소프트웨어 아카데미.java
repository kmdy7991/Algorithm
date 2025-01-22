import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int[] person = new int[n];
        
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			person[i] = stoi.apply(st.nextToken());
		}

		Arrays.sort(person);

		int s = 0;
		int e = n - 1;
		int res = 0;
        
		while (s < e) {
			if (person[s] + person[e] >= m) {
				s++;
				e--;
				res++;
			} else {
				s++;
			}
		}
		System.out.print(res);
	}
}