import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = stoi.apply(st.nextToken());
		int k = stoi.apply(st.nextToken());
		int q = stoi.apply(st.nextToken());
		int m = stoi.apply(st.nextToken());

		int[] check = new int[n + 3];
		boolean[] sleep = new boolean[n + 3];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < k; i++) {
			sleep[stoi.apply(st.nextToken())] = true;
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < q; i++) {
			int num = stoi.apply(st.nextToken());
			if (!sleep[num]) {
                
				for (int j = num; j < n + 3; j++) {
					if (j % num == 0 && !sleep[j]) {
						check[j] = 1;
					}
				}
			}
		}

		int[] student = new int[n + 3];
		for (int i = 3; i < n + 3; i++) {
			student[i] = (student[i - 1] + (check[i] == 0 ? 1 : 0));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int s = stoi.apply(st.nextToken());
			int e = stoi.apply(st.nextToken());

			sb.append(student[e] - student[s - 1]).append("\n");
		}
		System.out.println(sb);
	}
}