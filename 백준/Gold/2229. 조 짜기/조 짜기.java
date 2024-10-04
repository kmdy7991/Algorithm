import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		int[] student = new int[n + 1];
		int[] group = new int[n + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			student[i] = stoi.apply(st.nextToken());

            int max = 0;
			int min = (int) 1e5 + 1;
			for (int j = i; j > 0; j--) {
				max = Math.max(max, student[j]);
				min = Math.min(min, student[j]);
				group[i] = Math.max(group[i], max - min + group[j - 1]);
			}
		}
		
		System.out.println(group[n]);
	}
}